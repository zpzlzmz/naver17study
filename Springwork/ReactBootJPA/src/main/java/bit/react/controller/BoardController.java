package bit.react.controller;

import bit.react.data.BoardDto;
import bit.react.data.BoardEntity;
import bit.react.jwt.JwtUtil;
import bit.react.repository.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final NcpObjectStorageService storageService;
    private final JwtUtil jwtUtil;

    private String bucketName = "bitcamp.bucket";
    private String folderName = "board";

   /* @PostMapping(value="/auth/board/insert",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String insert(@RequestPart("upload") MultipartFile upload,
                         @RequestPart("dto") BoardDto dto,
                         HttpServletRequest request)
    {
        //사진은 Storage에 업로드
        String uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
        //현재 로그인한 username 정보를 header에서 얻기
        String auth = request.getHeader("Authorization");
        String token = auth.substring(7);
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);
        //하나씩 넣기
        BoardEntity boardEntity = BoardEntity.builder()
                .subject(dto.getSubject())
                .content(dto.getContent())
                .photo(uploadFilename)
                .username(username)
                .build();

        //save
        boardService.insertBoard(boardEntity);

        return "board insert ok!";
    }*/
   @PostMapping(value="/auth/board/insert",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
   public String insert(@RequestPart("upload") MultipartFile upload,
                        @RequestPart("subject") String subject,
                        @RequestPart("content") String content,
                        HttpServletRequest request)
   {
       //사진은 Storage에 업로드
       String uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
       //현재 로그인한 username 정보를 header에서 얻기
       String auth = request.getHeader("Authorization");
       String token = auth.substring(7);
       String username = jwtUtil.getUsername(token);
       String role = jwtUtil.getRole(token);
       //하나씩 넣기
       BoardEntity boardEntity = BoardEntity.builder()
               .subject(subject)
               .content(content)
               .photo(uploadFilename)
               .username(username)
               .build();

       //save
       boardService.insertBoard(boardEntity);

       return "board insert ok!";
   }

   @GetMapping("/board/list")
    public List<BoardEntity> getAllList() {
       return boardService.getAllBoards();
   }

   @GetMapping("/auth/board/detail")
    public BoardEntity selectData(@RequestParam("num") int num) {
       boardService.updateReadCount(num);
       return boardService.getData(num);
   }


   @DeleteMapping("/auth/board/delete")
    public String deleteBoard(@RequestParam("num") int num) {
       String oldPhotoname = boardService.getData(num).getPhoto();
       //스토리지에 업로드 된 사진 지우기
       storageService.deleteFile(bucketName, folderName, oldPhotoname);
       boardService.deleteBoard(num);
       //db삭제
       boardService.deleteBoard(num);
       return "board delete ok!";
   }

   @GetMapping("/auth/board/updateform")
    public BoardEntity updateForm(@RequestParam("num") int num) {
       return boardService.getData(num);
   }

    @PostMapping(value="/auth/board/update",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String update(@RequestParam("upload") MultipartFile upload,
                         @RequestParam("num") int num,
                         @RequestParam("subject") String subject,
                         @RequestParam("content") String content,
                         HttpServletRequest request)
    {

        //스토리지에 업로드 된 사진 지우기
        String oldPhotoname = boardService.getData(num).getPhoto();
        storageService.deleteFile(bucketName, folderName, oldPhotoname);

        //사진은 Storage에 업로드
        String uploadFilename = storageService.uploadFile(bucketName, folderName, upload);

        //하나씩 넣기
        BoardEntity boardEntity = BoardEntity.builder()
                .num(num)
                .subject(subject)
                .content(content)
                .photo(uploadFilename)
                .build();

        //save
        boardService.insertBoard(boardEntity);

        return "board insert ok!";
    }

}





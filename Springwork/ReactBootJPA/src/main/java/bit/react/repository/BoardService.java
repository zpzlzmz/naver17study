package bit.react.repository;

import bit.react.data.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private  final BoardRepository boardRepository;

    public void insertBoard(BoardEntity boardEntity) {
        boardRepository.save(boardEntity); //사진 포함 다 저장
    }

    //출력
    public List<BoardEntity> getAllBoards() {
        //num의 내림차순으로 정렬
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "num"));
    }

    //데이터 1개
    public BoardEntity getData(int num) {
        return boardRepository.getReferenceById(num);
    }

    //삭제
    public void deleteBoard(int num) {
        boardRepository.deleteById(num);
    }

    public void updateReadCount(int num) {
        boardRepository.updateReadCount(num);
    }

    //수정
    public void updateBoard(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
    }
}

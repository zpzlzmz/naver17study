/**
     * 로그인 화면 호출
     * @param loginForm
     * @return
     */
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm")LoginForm loginForm){
        return "login/loginForm";
    }

    /**
     * 로그인
     * @param form
     * @param bindingResult
     * @param redirectURL
     * @param request
     * @return
     */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm form
            , BindingResult bindingResult
            , @RequestParam(defaultValue = "/") String redirectURL
            , HttpServletRequest request){


        if (bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Member loginMember = loginService.login(form.getLoginId(), form.getPassword());
        if (loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "login/loginForm";
        }
        String memberName = loginMember.getMemberName();
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);
        session.setAttribute("loginId", form.getLoginId());
        session.setAttribute("loginName", memberName);
        return "redirect:" + redirectURL;
    }
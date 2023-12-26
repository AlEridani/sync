package home.server.syc.service;

import home.server.syc.domain.MemberVO;

public interface MemberService {
    int create(MemberVO vo);
    MemberVO read(String username);
    int update(MemberVO vo);
    int delete(MemberVO vo);
}

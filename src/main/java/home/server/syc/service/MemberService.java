package home.server.syc.service;

import home.server.syc.domain.MemberVO;

public interface MemberService {
    MemberVO create(MemberVO vo);
    MemberVO read(MemberVO vo);
    MemberVO update(MemberVO vo);
    void delete(MemberVO vo);
}

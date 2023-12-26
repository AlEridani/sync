package home.server.syc.dao;

import home.server.syc.domain.MemberVO;

public interface MemberDAO {
    int insertMember(MemberVO vo);
    MemberVO selectMember(String username);

    int updateMember(MemberVO vo);

    int deleteMember(MemberVO vo);
}

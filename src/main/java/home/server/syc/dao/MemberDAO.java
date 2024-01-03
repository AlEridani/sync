package home.server.syc.dao;

import home.server.syc.domain.MemberEntity;

public interface MemberDAO {
    int insertMember(MemberEntity vo);
    MemberEntity selectMember(String username);

    int updateMember(MemberEntity vo);

    int deleteMember(MemberEntity vo);
}

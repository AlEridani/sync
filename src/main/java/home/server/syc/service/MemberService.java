package home.server.syc.service;

import home.server.syc.domain.MemberEntity;

public interface MemberService {
    MemberEntity create(MemberEntity vo);
    MemberEntity read(MemberEntity vo);
    MemberEntity update(MemberEntity vo);
    void delete(MemberEntity vo);
}

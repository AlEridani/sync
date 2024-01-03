package home.server.syc.dao;

import home.server.syc.domain.MemberEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberDAOImple implements MemberDAO{
    private Logger logger = LoggerFactory.getLogger(MemberDAOImple.class);


    @Override
    public int insertMember(MemberEntity vo){

        return 0;
    }

    @Override
    public MemberEntity selectMember(String username) {
        return null;
    }

    @Override
    public int updateMember(MemberEntity vo) {
        return 0;
    }

    @Override
    public int deleteMember(MemberEntity vo) {
        return 0;
    }
}

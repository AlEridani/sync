package home.server.syc.dao;

import home.server.syc.domain.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberDAOImple implements MemberDAO{
    private Logger logger = LoggerFactory.getLogger(MemberDAOImple.class);


    @Override
    public int insertMember(MemberVO vo){

        return 0;
    }

    @Override
    public MemberVO selectMember(String username) {
        return null;
    }

    @Override
    public int updateMember(MemberVO vo) {
        return 0;
    }

    @Override
    public int deleteMember(MemberVO vo) {
        return 0;
    }
}

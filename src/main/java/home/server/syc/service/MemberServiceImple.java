package home.server.syc.service;

import home.server.syc.dao.MemberDAO;
import home.server.syc.domain.MemberRepository;
import home.server.syc.domain.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


public class MemberServiceImple implements MemberService{
    private Logger logger = LoggerFactory.getLogger(MemberServiceImple.class);

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public int create(MemberVO vo) {
        logger.info("insertMember() called");
        return dao.insertMember(vo);
    }

    @Override
    public MemberVO read(String username) {
        logger.info("selectMember() called");
        return dao.selectMember(username);
    }

    @Override
    public int update(MemberVO vo) {
        logger.info("updateMember() called");
        return dao.updateMember(vo);
    }

    @Override
    public int delete(MemberVO vo) {
        logger.info("deleteMember() called");
        return dao.deleteMember(vo);
    }
}

package home.server.syc.service;

import home.server.syc.dao.MemberDAO;
import home.server.syc.domain.MemberRepository;
import home.server.syc.domain.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;

@Service

public class MemberServiceImple implements MemberService{
    private Logger logger = LoggerFactory.getLogger(MemberServiceImple.class);

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public MemberVO  create(MemberVO vo) {
        logger.info("insertMember() called");
        if (memberRepository.findByUsername(vo.getUsername()) != null)
            throw new InvalidParameterException("이미 존재하는 회원입니다.");
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        return memberRepository.save(vo);
    }

    @Override
    public MemberVO read(MemberVO vo) {
        logger.info("selectMember() called");
        String CryptPassword = memberRepository.findByUsername(vo.getUsername()).getPassword();
        boolean passwordMatches =  passwordEncoder.matches(vo.getPassword(), CryptPassword);
        if(passwordMatches){
            return memberRepository.findByUsername(vo.getUsername());
        }
        throw new InvalidParameterException("비밀번호 불일치");
    }

    @Override
    public MemberVO  update(MemberVO vo) {
        logger.info("updateMember() called");
        if (memberRepository.findByUsername(vo.getUsername()) == null)
            throw new InvalidParameterException("존재하지 않는 회원입니다.");
        return memberRepository.save(vo);
    }

    @Override
    public void  delete(MemberVO vo) {
        logger.info("deleteMember() called");
        if (memberRepository.findByUsername(vo.getUsername()) != null)
            memberRepository.delete(vo);
        else {
            throw new InvalidParameterException("존재하지 않는 회원입니다.");
        }
    }
}

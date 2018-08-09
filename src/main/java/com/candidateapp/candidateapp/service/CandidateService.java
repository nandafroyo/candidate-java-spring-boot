/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.candidateapp.candidateapp.service;

import com.candidate.entity.Candidate;
import com.candidateapp.candidateapp.repo.CandidateRepo;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author actnow
 */

@Service("candidateService")
@Transactional
public class CandidateService {
    @Autowired //inject repository
    private CandidateRepo repo;
    
    public Candidate insert(Candidate candidate){
        return repo.save(candidate);
    }
    
    public List<Candidate> findAll(){
        return repo.findAllCandidate();
    }
    
    public List<Candidate> findByName(String name){
        return repo.findByName(name);
    }
    
    public boolean delete(Long id){
        repo.delete(id);
        return true;
    }
    
}

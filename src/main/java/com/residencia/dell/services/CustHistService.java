package com.residencia.dell.services;

import com.residencia.dell.entities.CustHist;
import com.residencia.dell.exceptions.CustHistException;
import com.residencia.dell.repositories.CustHistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustHistService {

    @Autowired
    CustHistRepository custHistRepository;

    public List<CustHist> listarTodos() {
        return custHistRepository.findAll();
    }

    public CustHist salvar(CustHist custHist) {
        return custHistRepository.save(custHist);
    }

    public CustHist salvarComRetorno(CustHist custHist) {
        return custHistRepository.save(custHist);
    }

    public void update(CustHist custHist, Integer id) throws CustHistException {
        if (null == id) {
            throw new CustHistException("Não foi informado um ID válido.");

        }
        custHistRepository.save(custHist);
    }
}

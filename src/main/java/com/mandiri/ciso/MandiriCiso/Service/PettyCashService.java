package com.mandiri.ciso.MandiriCiso.Service;

import com.mandiri.ciso.MandiriCiso.Model.PettyCash;
import com.mandiri.ciso.MandiriCiso.Repository.PettyCashRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PettyCashService {
    private final PettyCashRepo pettyCashRepo;

    public PettyCashService(PettyCashRepo pettyCashRepo) {
        this.pettyCashRepo = pettyCashRepo;
    }

    public List<PettyCash> getList(){
        return pettyCashRepo.findAll();
    }

    public PettyCash newPettyCash(PettyCash pettyCash){
        return pettyCashRepo.save(pettyCash);
    }
}

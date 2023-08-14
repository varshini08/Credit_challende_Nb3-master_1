package com.tra.rest.tra;

import com.tra.rest.tra.Repo.TransactionRepository;
import com.tra.rest.tra.Util.Service;
import com.tra.rest.tra.entity.Customer;
import com.tra.rest.tra.entity.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TransactionSpec {
    @Mock
    TransactionRepository Transrep;
    @InjectMocks
    Service Transservice;
    @BeforeEach
    public void firstBeforeEach() {

        MockitoAnnotations.initMocks(this);
    }
    List<Transaction> collection;
    Transaction Trans1, Trans2, Trans3;

    @BeforeEach
    public void befEach() {
        Trans1 = new Transaction("23/02/2022",40.11,1,324,"Achille","OK",74720,"Abbott-ro","GrocerryShopping","Felicia","Thomas");
        Trans2 = new Transaction("12/09/1973",52.96,2,583,"Sta","TN",98000,"Afdobe","VideoEditor","French","robert");
        Trans3 = new Transaction("24/04/1966",98.07,3,983,"swam","MH",8600,"Dober","HomeKeeper","palazo","john");

        collection = .asList(Trans1, Trans2, Trans3)
    }


}

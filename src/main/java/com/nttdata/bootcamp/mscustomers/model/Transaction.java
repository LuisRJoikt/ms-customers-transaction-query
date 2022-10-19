package com.nttdata.bootcamp.mscustomers.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("transactions")
public class Transaction {
    @Id
    private String id;
    private String nroAccount;
    private String moveType; //movement type
    private String moveDet;  //movement detail
    private Double amouMove; //amount movement
    private Date dateTime;
}

package org.sid.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebankingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE )
@DiscriminatorColumn(name = "TYPE",length = 4,discriminatorType = DiscriminatorType.STRING)
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date creatdAt;
   private AccountStatus status;
   @ManyToOne
   private Customer customer;
   @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;

}

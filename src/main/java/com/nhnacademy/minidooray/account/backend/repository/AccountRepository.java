package com.nhnacademy.minidooray.account.backend.repository;

import com.nhnacademy.minidooray.account.backend.domain.dto.AccountPageInfoDTO;
import com.nhnacademy.minidooray.account.backend.domain.dto.AccountStatusInfoDTO;
import com.nhnacademy.minidooray.account.backend.entity.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Modifying
    @Query("UPDATE Account a SET a.status = ?2 WHERE a.id = ?1")
    void updateStatus(String id, String status);

    Optional<AccountPageInfoDTO> getAccountPageInfoById(String id);

    Optional<AccountStatusInfoDTO> getAccountStatusInfoByIdAndPassword(String id, String password);
}

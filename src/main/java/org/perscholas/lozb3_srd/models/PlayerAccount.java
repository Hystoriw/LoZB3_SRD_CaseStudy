package org.perscholas.lozb3_srd.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class PlayerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int accId;

    @NotNull
    @NonNull
    String userName;

    @NotNull
    @NonNull
    String password;

    @OneToMany
    List<CharacterSheet> characterSheetList;

    @ManyToMany
    List<GMAccount> gmAccountList;
}

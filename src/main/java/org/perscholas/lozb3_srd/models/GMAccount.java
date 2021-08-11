package org.perscholas.lozb3_srd.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class GMAccount extends PlayerAccount{
    @ManyToMany
    List<PlayerAccount> playerAccountList;
}

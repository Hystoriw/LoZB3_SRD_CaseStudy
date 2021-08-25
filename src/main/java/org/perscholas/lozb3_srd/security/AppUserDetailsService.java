package org.perscholas.lozb3_srd.security;

import org.perscholas.lozb3_srd.dao.IAuthGroupRepo;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.models.AuthGroup;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
        2.

 */

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final IPlayerAccountRepo playerAccountRepo;
    private final IAuthGroupRepo iAuthGroupRepo;

    @Autowired
    public AppUserDetailsService(IPlayerAccountRepo playerAccountRepo, IAuthGroupRepo iAuthGroupRepo) {
        this.playerAccountRepo = playerAccountRepo;
        this.iAuthGroupRepo = iAuthGroupRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<PlayerAccount> player = playerAccountRepo.findByUsername(s);
        if(player.isEmpty())
            throw new UsernameNotFoundException("Cannot find Username: " + s);
            List<AuthGroup> authGroups = this.iAuthGroupRepo.findByaUsername(s);
            return new AppUserPrincipal(player.get(),authGroups);
        }
    }


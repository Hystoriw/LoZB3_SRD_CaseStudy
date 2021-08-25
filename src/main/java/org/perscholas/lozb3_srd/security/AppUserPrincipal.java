package org.perscholas.lozb3_srd.security;

import org.perscholas.lozb3_srd.models.AuthGroup;
import org.perscholas.lozb3_srd.models.PlayerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/*
            1. begin here

 */


public class AppUserPrincipal implements UserDetails {

    private PlayerAccount playerAccount;
    private List<AuthGroup> authGroups;

    public AppUserPrincipal(PlayerAccount playerAccount, List<AuthGroup> authGroups) {
        this.playerAccount = playerAccount;
        this.authGroups = authGroups;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null == authGroups){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        authGroups.forEach(authGroup -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(authGroup.getAAuthGroup()));
        });
        return grantedAuthorities;

       // return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return this.playerAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return this.playerAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

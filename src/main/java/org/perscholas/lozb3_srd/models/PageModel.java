package org.perscholas.lozb3_srd.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
@Component
public class PageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer pageId;

    @NotNull
    @NonNull
    @Column(unique = true)
    String pageName;
    String pageTitle; // often the same as the page's name, but not necessarily

    @ManyToMany
    List<PageModel> childPages;

    @ManyToMany
    List<PageModel> parentPages; // several pages can share a single subpage; possibly for Errata sections or version control

    @OneToMany
    List<RuleModel> ruleList;
}

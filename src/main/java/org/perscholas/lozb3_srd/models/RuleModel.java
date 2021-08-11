package org.perscholas.lozb3_srd.models;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Slf4j
public class RuleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String ruleId;

    @NotNull
    @NonNull
    @Column(unique = true)
    String ruleName;
    String ruleTitle; // can be the same as ruleName

    String sourceBook; // title of the book the rule originates from; will be exclusively "Legend of Zelda RPG Basic Edition" in this project
    String sourceHref; // hyperlink destination for the book's download page
    String chapterPage; // "ch.#, pg.#"

    String ruleBody; // can be any length, and can include HTML elements to format the rule's text and add tables

    String ruleFooter; // used for errata, updates, and links to old versions of the same rules
}

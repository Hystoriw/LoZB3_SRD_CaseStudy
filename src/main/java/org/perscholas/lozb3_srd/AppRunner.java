package org.perscholas.lozb3_srd;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Rule;
import org.perscholas.lozb3_srd.dao.*;
import org.perscholas.lozb3_srd.models.*;
import org.perscholas.lozb3_srd.services.CharacterSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@Transactional
public class AppRunner implements CommandLineRunner {
    ICharacterSheetRepo characterSheetRepo;
    IPageModelRepo pageModelRepo;
    IPlayerAccountRepo playerAccountRepo;
    IRuleModelRepo ruleModelRepo;
    IAuthGroupRepo authGroupRepo;

    @Autowired
    public AppRunner(ICharacterSheetRepo characterSheetRepo, IPageModelRepo pageModelRepo, IPlayerAccountRepo playerAccountRepo, IRuleModelRepo ruleModelRepo, IAuthGroupRepo authGroupRepo) {
        this.characterSheetRepo = characterSheetRepo;
        this.pageModelRepo = pageModelRepo;
        this.playerAccountRepo = playerAccountRepo;
        this.ruleModelRepo = ruleModelRepo;
        this.authGroupRepo = authGroupRepo;
    }


    // TODO: Override the run() method to generate some basic data for the app to test with
    @Override
    public void run(String... args) {
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("Adding a main page with sql statements.");
//        PageModel mainPage = new PageModel("Main Page");
//        mainPage.setPageTitle("Main Page");
        PageModel mainPage = createNewPage(pageModelRepo, "Main Page");


//        RuleModel missionStatement = new RuleModel("Mission Statement");
//        missionStatement.setRuleTitle("Mission Statement");
//        missionStatement.setSourceBook("Legend of Zelda Beta 3");
//        missionStatement.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
//        missionStatement.setChapterPage("ch.1, pg.3");
//        missionStatement.setRuleText("This system is intended to accomplish three main goals:\n" +
//                "\n" +
//                "     1. Make a Legend of Zelda RPG, not a Legend of Zelda flavored RPG : The core mission statement of this system is to make a game that captures the characteristic style of gameplay that the Legend of Zelda video games are known for. This primarily entails a central emphasis on acquired items as the primary determiner of character capabilities, and a prominent presence of puzzles requiring specific items to solve. Combat, particularly boss battles, should have a puzzle-like aspect as well. And of course, all the classic LoZ items and races and such should be represented for use in games. It's not sufficient to merely have a system capable of incorporating these elements; it should be specifically geared to promote a uniquely and recognizably Legend-of-Zelda style of play.\n" +
//                "\n" +
//                "     2. Synthesize and expand on the video games, don't merely replicate them : While emulating the characteristic style of the Zelda games is the #1 priority, that doesn't mean we should limit ourselves to only the things you can do in those games. Any archetype that would reasonably fit into any of the Zelda settings should be feasible; not all PCs will be Hylian sword-and-boarders. The beauty of pen-and-paper RPGs is that they aren't limited by the same technical constraints that bind video games, and the Zelda series has very rich settings with lots stuff to work with; we should be free to let our imaginations run a bit wild. Likewise, unless it would add excessive complexity to the core of the system or threatens to render an item utterly redundant, there's no harm in allowing characters to do things that should reasonably be possible but can't be done in the video games. (It's important to note here that even if an item's original purpose in a given game is rendered moot by allowing a certain action, that doesn't mean the item can't be slightly adapted to still have a purpose. For instance, it would be reasonable to allow all characters to swim, barring conflicting racial traits such as a Goron's density, but that doesn't mean you can't still have a use for stuff like the Zora's Flippers or Zora Armor.)\n" +
//                "\n" +
//                "     3. Simplicity and Accessibility : We want this game to be easy to learn and easy to play, even for Zelda fans who've never played a tabletop game before. Of course, there is a point of diminishing returns where trimming down the rules hurts the system's robustness more than it improves ease of use, and we want to avoid that, but as a rule of thumb, keep it simple.");
        RuleModel missionStatement = createNewRule(ruleModelRepo,
                "Mission Statement",
                "1", "3",
                "This system is intended to accomplish three main goals:\n" +
                        "\n" +
                        "     1. Make a Legend of Zelda RPG, not a Legend of Zelda flavored RPG : The core mission statement of this system is to make a game that captures the characteristic style of gameplay that the Legend of Zelda video games are known for. This primarily entails a central emphasis on acquired items as the primary determiner of character capabilities, and a prominent presence of puzzles requiring specific items to solve. Combat, particularly boss battles, should have a puzzle-like aspect as well. And of course, all the classic LoZ items and races and such should be represented for use in games. It's not sufficient to merely have a system capable of incorporating these elements; it should be specifically geared to promote a uniquely and recognizably Legend-of-Zelda style of play.\n" +
                        "\n" +
                        "     2. Synthesize and expand on the video games, don't merely replicate them : While emulating the characteristic style of the Zelda games is the #1 priority, that doesn't mean we should limit ourselves to only the things you can do in those games. Any archetype that would reasonably fit into any of the Zelda settings should be feasible; not all PCs will be Hylian sword-and-boarders. The beauty of pen-and-paper RPGs is that they aren't limited by the same technical constraints that bind video games, and the Zelda series has very rich settings with lots stuff to work with; we should be free to let our imaginations run a bit wild. Likewise, unless it would add excessive complexity to the core of the system or threatens to render an item utterly redundant, there's no harm in allowing characters to do things that should reasonably be possible but can't be done in the video games. (It's important to note here that even if an item's original purpose in a given game is rendered moot by allowing a certain action, that doesn't mean the item can't be slightly adapted to still have a purpose. For instance, it would be reasonable to allow all characters to swim, barring conflicting racial traits such as a Goron's density, but that doesn't mean you can't still have a use for stuff like the Zora's Flippers or Zora Armor.)\n" +
                        "\n" +
                        "     3. Simplicity and Accessibility : We want this game to be easy to learn and easy to play, even for Zelda fans who've never played a tabletop game before. Of course, there is a point of diminishing returns where trimming down the rules hurts the system's robustness more than it improves ease of use, and we want to avoid that, but as a rule of thumb, keep it simple.");

//        RuleModel howToBeASage = new RuleModel("How To Be A Sage");
//        howToBeASage.setRuleTitle("How To Be A Sage");
//        howToBeASage.setSourceBook("Legend of Zelda Beta 3");
//        howToBeASage.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
//        howToBeASage.setChapterPage("ch.2, pg.5");
//        howToBeASage.setRuleText("This system was designed with the goal of bringing new players into the hobby of pen and paper roleplaying. As such, many mechanical choices were made to minimize the workload on the player, often at the expense of the Sage. But don’t fret, this section here is a quick rundown of how to run this system in a fun and engaging manner while keeping your players going. So first, some terminology.\n" +
//                "\n" +
//                "A roleplaying game is of course a set of rules constructed to allow players to take on the persona of fictitious characters and act out heroic adventures with them. These adventures are usually structured around series of quests linking together a grand campaign of story that may even change the world of the heroes. There are many systems available to do this that are widely known, such as Dungeons and Dragons. All roleplaying games tend to share features with each other, such as the ability to resolve challenges.\n" +
//                "\n" +
//                "A d6, a standard six sided die like you would find in monopoly or a craps table, is the only die needed to play the Legend of Zelda RPG, although you may want a great deal more than one. The skills of your character and the conditions of the scenario surrounding a challenge determine how many d6 you roll to somewhat randomly determine the success of a challenge. In this system, each die essentially acts as a coin toss because only fours and up matter on any individual die. This dice pool success mechanic generates a good bell curve of probability that can be relied upon for relatively stable outcomes, unlike a heartless d20 that D&D relies upon.\n" +
//                "\n" +
//                "As characters progress, their skills increase to keep with the theme of a heroic journey. And heroes of course always get better as the story goes on. Completing one quest makes them better able to tackle the next one, so challenges should generally become more difficult as the grand campaign progresses. For example, consider the dungeons in Ocarina of Time if you’ve played it. The Great Deku Tree is a much easier dungeon to complete than the Water Temple, and this is because through his journeying, Link has become much more capable, so he is able to take on my challenging quests.\n" +
//                "\n" +
//                "Challenges come in many different forms, especially in the Legend of Zelda. The most obvious challenges are of course fighting enemies. But sometimes it’s convincing a shopkeeper to confide secrets in you, or stealing an artifact from a noble, breaking into a desert fortress, besting a war chief in a wrestling match, chasing down milk thieves on horseback, collecting rare insects, sliding block puzzles, tracking the flooding of a temple, defending a city from siege, or a million other things. Varying the challenges in a meaningful way is a key component of having a successful and fun campaign with your players.\n" +
//                "\n" +
//                "Given enough repetition, anything will get dull. The same challenge should never occur twice in a row. If one room is an ambush, the second room shouldn’t also be an ambush. The challenges should surprise and intrigue your players, encouraging them to think dynamically about the scenario and how to deal with it. If your players find themselves in a position where they have fallen into a rut of simple commands, you need to throw a curveball at them. Blow out the torches, flood the room with sand, have the dead rise among them, a cave in block their retreat, or anything to change up the pattern. Just be careful to make sure your players are able to survive it.\n" +
//                "\n" +
//                "On the subject of the survivability of your players. Never ever kill the entire party by making a challenge to difficult, but don’t coddle them either. If there is no threat of everyone’s characters dying, then they won’t take the game seriously. On the other end of the spectrum is when they die too often, and this leads to assumed helplessness and the disposability of characters, which is also bad. A happy medium needs to be found, even if that means cheating.On the subject of cheating as the Sage. It doesn’t exist, you cannot cheat because you make the rules of the scenario. But that doesn’t mean that you can ignore the rules of the system as you please, they are there for a reason. If you flaunt your immunity from the rules too easily, your players may find themselves at a loss of understanding what they are actually able to do. \n" +
//                "\n" +
//                "So, if you are going to cheat, do it by changing things they aren’t aware of anyways. Add life to monsters that seem to be dying too quickly, lower the damage of a certain trap, throw in hints of weaknesses about the boss, have a stray piece of narrative change the encounter in favor of the players. This is a game about having fun, not hammering numbers at one another until someone says uncle.\n" +
//                "\n" +
//                "Over the course of a quest, there should be a progression of difficulty to gauge how the players are handling things. This will allow for adjustment or perhaps even outright removal of aspects that will simply be no fun for anyone. Experienced Sages who know their players well may of course be able to simply ignore this progression and hit the nail on the head anyways, but that’s a risky line to tread.\n" +
//                "\n" +
//                "Development of story and motivation for the players is up to each individual Sage and group to decide. It could range anywhere from four guys meet in a tavern and venture off together, to complex political darkness in a land fraught with civil war fueled by interesting character backgrounds and roleplay interactions. Either is a perfectly acceptable approach to playing a roleplaying game such as this. That is why it was built to run anything the group would want to run within the themes of Legend of Zelda.\n" +
//                "\n" +
//                "Once you have motivation, and a story for what kind of challenges you want the party to challenge, you should double check that you aren’t railroading them. Railroading is a term for when the Sage takes control of the party and forces them into a scenario regardless of if they wish to be doing it at all. It is rarely any fun for anyone. Players should go on the quest of their own will, and if you’re really good at it you can trick them into thinking it’s what they want to do without them even realizing it. Play off their characters, offer rewards, or come up with something else that isn’t forcing them to follow your special little story. Remember, this isn’t the story of the Sage, it’s a narrative constructed by the group, the Sage just controls the world around the players.\n" +
//                "\n" +
//                "A similar fallacy many Sages make is running a character of their own. This may not seem like such an issue, but it is far too easy to fall into the trap of giving yourself all the spotlight. This is no fun for the players, do not do this. What you can do however, is creat a companion for the party. A Navi, or a Tael, the Red Lion, Midna, or Kaepora Gaepora. All of these are perfectly within the realm of Legend of Zelda. Powerless companions like this give you the ability to help them within the realm of the game world. Sometimes puzzles will simply be too difficult for some reason, and a hint from the Sage will easily push things along and keep the game fun.\n" +
//                "\n" +
//                "Now that you’ve brought your party to the dungeon, which of course is the loosest of definitions since a dungeon is just a set of challenges they must overcome, you need to bring them along and let them explore the dungeon. A premade map of the dungeon with notes about the challenges will help tremendously with the dungeoneering process. Grid paper is a great aid in the map making process as it allows you to create a scale replica of the battlegrid the players will be combating on.\n" +
//                "\n" +
//                "While the placement and maneuvering of enemies in combat is fairly straightforward after the room has been constructed, bringing the dungeon to life for the players is its own challenge all together. Every room should be functionally described to the players in enough detail that they are able to ask questions about it and reason through the puzzles on their own. Who knows, maybe they’ll find a clever bypass and triumph over the puzzle without actually tackling it head on, that’s the fun of the game after all.\n" +
//                "\n" +
//                "When describing a room or a challenge, it is usually best to move from most important to least important, such as what is mechanically affecting them then what the décor on the wall mural depicts. The size of the room, lighting conditions, prominent obstacles, and enemies should always be mentioned when entering a new room. Details on top of that add flavor to the dungeon and present the challenge to the players. The more lively the description and thechallenge, the more fun. No need to overdo this however. Something along the lines of, “Fraying rope bridges connect the two towers, beware! There are fire keese attacking you! Roll for initiative!”\n" +
//                "\n" +
//                "The above example also illustrates the concept of dynamic encounters. There are multiple layers to the entire challenge providing many different ways to approach it. If there is only one way to succeed, the challenge will feel dull in comparison. In the tower example, the party could stay behind cover and attack the keese, risking the destruction of the bridges. Or they could all sprint across the bridges, and risk them collapsing under the weight. Or perhaps they could use a spell to pull them across, or a song to repair the bridge before it fails. Perhaps the item they got a few rooms ago will help them knock the keese away. Any and all of those solutions are up to the players to discover and utilize.\n" +
//                "\n" +
//                "Rolling with the punches is another key aspect to being a good Sage. Players can very easily find clever bypasses to your puzzle, or cheesy ways to kill all the mooks without risking themselves. This is okay. For that scenario at least, of course you should prevent this from happening again whether it be out of character discussion about the problem, or just planning for it to happen and countering it. If the game is interrupted by exploits, it is never a good thing. Don’t God mode the enemies to do this however, that’s as bad as railroading your players.\n" +
//                "\n" +
//                "So far, most of this advice is broadly applicable to all forms of roleplaying games, there are some specific things to be included to make a distinctly Legend of Zelda feel in the game. The video games have a pretty distinct hero vs villain theme throughout, but that doesn’t need to be included. Legend of Zelda is loved for it’s combination of action and adventure. You fight strange monsters with strange attacks that force you to find creative ways to deal with them. Like Stalfos that resurrect if their partner isn’t defeated in time, or octorock that require you to reflect their attack back at them, or any of the bosses. And between the fights, you deal with dangerous traps that test your cunning, and devious puzzles to test your wit.\n" +
//                "\n" +
//                "Enemies don’t need to be touched on much. Their generation is very simple and quick and their effect on the party should only be a mild drain on their resources rather than constant life or death struggles. Giving them various techniques and spells in cohesion with one another can easily give every fight a unique aspect unlike the previous encounters. Mid-Bosses should of course receive much more attention than your generic room-to-room mooks. Their battle style should reflect the theme of the dungeon somehow, and they usually guard the dungeons secondary treasure. Be careful to not let the Mid-Boss upstage the Dungeon Boss however.\n" +
//                "\n" +
//                "Dungeon Bosses are critical to Zelda style dungeons. They are the capstone of triumph over the dungeon and are the most difficult adversary the party will face in the entire dungeon. Their skills should be carefully defined and utilized, as well as the room they are encountered in. The Dungeon Boss should have a trick to beating them in a reliable way, but must also allow players to get creative, and be rewarded for their creativity. Just because the plan was for them to use fire arrows to melt the ice barriers doesn’t mean bombs won’t do it better. Every Dungeon Boss should be tailored to the dungeon it is guarding, thematically and mechanically.All of this is fairly standard fair for roleplaying games. The emphasis on puzzles is where the trickery for being the Sage comes in. There are a couple ways to approach puzzles in a pen and paper format. You can of course use traditional paper puzzles, such as disguised chess puzzles, riddles, and slide puzzles. Clever paths and hidden levers to change the area until everything falls into place is a more complex puzzle that can be used to gain access to certain areas.\n" +
//                "\n" +
//                "Mechanical puzzles can be the most intriguing however. Consider environmental effects during a multiple stage combat. Falling sand that inhibits movement, burning coals that damage you for not moving, sliding on wet ice, collapsing platforms, illusionary paths filled with traps, a vibrating membrane knocking everyone down, drifting rafts , flipping ice shelves, magnetic walls, flooding waterfalls, quicksand pits, lightning storms, burrowing wyrms, tumbling rocks, or a million other things. The key being to change the scenario in some unique way, often using recently acquired items to overcome these puzzles.\n" +
//                "\n" +
//                "In the end, creating a Legend of Zelda experience is about enjoying a quest that is about defeating monsters, solving puzzles, saving the day, roleplaying, and having a good time. The Sage needs to create a diverse world, and the players have to put their effort through as well.");
        RuleModel howToBeASage = createNewRule(ruleModelRepo,
                "How To Be A Sage",
                "2", "5",
                "This system was designed with the goal of bringing new players into the hobby of pen and paper roleplaying. As such, many mechanical choices were made to minimize the workload on the player, often at the expense of the Sage. But don’t fret, this section here is a quick rundown of how to run this system in a fun and engaging manner while keeping your players going. So first, some terminology.\n" +
                        "\n" +
                        "A roleplaying game is of course a set of rules constructed to allow players to take on the persona of fictitious characters and act out heroic adventures with them. These adventures are usually structured around series of quests linking together a grand campaign of story that may even change the world of the heroes. There are many systems available to do this that are widely known, such as Dungeons and Dragons. All roleplaying games tend to share features with each other, such as the ability to resolve challenges.\n" +
                        "\n" +
                        "A d6, a standard six sided die like you would find in monopoly or a craps table, is the only die needed to play the Legend of Zelda RPG, although you may want a great deal more than one. The skills of your character and the conditions of the scenario surrounding a challenge determine how many d6 you roll to somewhat randomly determine the success of a challenge. In this system, each die essentially acts as a coin toss because only fours and up matter on any individual die. This dice pool success mechanic generates a good bell curve of probability that can be relied upon for relatively stable outcomes, unlike a heartless d20 that D&D relies upon.\n" +
                        "\n" +
                        "As characters progress, their skills increase to keep with the theme of a heroic journey. And heroes of course always get better as the story goes on. Completing one quest makes them better able to tackle the next one, so challenges should generally become more difficult as the grand campaign progresses. For example, consider the dungeons in Ocarina of Time if you’ve played it. The Great Deku Tree is a much easier dungeon to complete than the Water Temple, and this is because through his journeying, Link has become much more capable, so he is able to take on my challenging quests.\n" +
                        "\n" +
                        "Challenges come in many different forms, especially in the Legend of Zelda. The most obvious challenges are of course fighting enemies. But sometimes it’s convincing a shopkeeper to confide secrets in you, or stealing an artifact from a noble, breaking into a desert fortress, besting a war chief in a wrestling match, chasing down milk thieves on horseback, collecting rare insects, sliding block puzzles, tracking the flooding of a temple, defending a city from siege, or a million other things. Varying the challenges in a meaningful way is a key component of having a successful and fun campaign with your players.\n" +
                        "\n" +
                        "Given enough repetition, anything will get dull. The same challenge should never occur twice in a row. If one room is an ambush, the second room shouldn’t also be an ambush. The challenges should surprise and intrigue your players, encouraging them to think dynamically about the scenario and how to deal with it. If your players find themselves in a position where they have fallen into a rut of simple commands, you need to throw a curveball at them. Blow out the torches, flood the room with sand, have the dead rise among them, a cave in block their retreat, or anything to change up the pattern. Just be careful to make sure your players are able to survive it.\n" +
                        "\n" +
                        "On the subject of the survivability of your players. Never ever kill the entire party by making a challenge to difficult, but don’t coddle them either. If there is no threat of everyone’s characters dying, then they won’t take the game seriously. On the other end of the spectrum is when they die too often, and this leads to assumed helplessness and the disposability of characters, which is also bad. A happy medium needs to be found, even if that means cheating.On the subject of cheating as the Sage. It doesn’t exist, you cannot cheat because you make the rules of the scenario. But that doesn’t mean that you can ignore the rules of the system as you please, they are there for a reason. If you flaunt your immunity from the rules too easily, your players may find themselves at a loss of understanding what they are actually able to do. \n" +
                        "\n" +
                        "So, if you are going to cheat, do it by changing things they aren’t aware of anyways. Add life to monsters that seem to be dying too quickly, lower the damage of a certain trap, throw in hints of weaknesses about the boss, have a stray piece of narrative change the encounter in favor of the players. This is a game about having fun, not hammering numbers at one another until someone says uncle.\n" +
                        "\n" +
                        "Over the course of a quest, there should be a progression of difficulty to gauge how the players are handling things. This will allow for adjustment or perhaps even outright removal of aspects that will simply be no fun for anyone. Experienced Sages who know their players well may of course be able to simply ignore this progression and hit the nail on the head anyways, but that’s a risky line to tread.\n" +
                        "\n" +
                        "Development of story and motivation for the players is up to each individual Sage and group to decide. It could range anywhere from four guys meet in a tavern and venture off together, to complex political darkness in a land fraught with civil war fueled by interesting character backgrounds and roleplay interactions. Either is a perfectly acceptable approach to playing a roleplaying game such as this. That is why it was built to run anything the group would want to run within the themes of Legend of Zelda.\n" +
                        "\n" +
                        "Once you have motivation, and a story for what kind of challenges you want the party to challenge, you should double check that you aren’t railroading them. Railroading is a term for when the Sage takes control of the party and forces them into a scenario regardless of if they wish to be doing it at all. It is rarely any fun for anyone. Players should go on the quest of their own will, and if you’re really good at it you can trick them into thinking it’s what they want to do without them even realizing it. Play off their characters, offer rewards, or come up with something else that isn’t forcing them to follow your special little story. Remember, this isn’t the story of the Sage, it’s a narrative constructed by the group, the Sage just controls the world around the players.\n" +
                        "\n" +
                        "A similar fallacy many Sages make is running a character of their own. This may not seem like such an issue, but it is far too easy to fall into the trap of giving yourself all the spotlight. This is no fun for the players, do not do this. What you can do however, is creat a companion for the party. A Navi, or a Tael, the Red Lion, Midna, or Kaepora Gaepora. All of these are perfectly within the realm of Legend of Zelda. Powerless companions like this give you the ability to help them within the realm of the game world. Sometimes puzzles will simply be too difficult for some reason, and a hint from the Sage will easily push things along and keep the game fun.\n" +
                        "\n" +
                        "Now that you’ve brought your party to the dungeon, which of course is the loosest of definitions since a dungeon is just a set of challenges they must overcome, you need to bring them along and let them explore the dungeon. A premade map of the dungeon with notes about the challenges will help tremendously with the dungeoneering process. Grid paper is a great aid in the map making process as it allows you to create a scale replica of the battlegrid the players will be combating on.\n" +
                        "\n" +
                        "While the placement and maneuvering of enemies in combat is fairly straightforward after the room has been constructed, bringing the dungeon to life for the players is its own challenge all together. Every room should be functionally described to the players in enough detail that they are able to ask questions about it and reason through the puzzles on their own. Who knows, maybe they’ll find a clever bypass and triumph over the puzzle without actually tackling it head on, that’s the fun of the game after all.\n" +
                        "\n" +
                        "When describing a room or a challenge, it is usually best to move from most important to least important, such as what is mechanically affecting them then what the décor on the wall mural depicts. The size of the room, lighting conditions, prominent obstacles, and enemies should always be mentioned when entering a new room. Details on top of that add flavor to the dungeon and present the challenge to the players. The more lively the description and thechallenge, the more fun. No need to overdo this however. Something along the lines of, “Fraying rope bridges connect the two towers, beware! There are fire keese attacking you! Roll for initiative!”\n" +
                        "\n" +
                        "The above example also illustrates the concept of dynamic encounters. There are multiple layers to the entire challenge providing many different ways to approach it. If there is only one way to succeed, the challenge will feel dull in comparison. In the tower example, the party could stay behind cover and attack the keese, risking the destruction of the bridges. Or they could all sprint across the bridges, and risk them collapsing under the weight. Or perhaps they could use a spell to pull them across, or a song to repair the bridge before it fails. Perhaps the item they got a few rooms ago will help them knock the keese away. Any and all of those solutions are up to the players to discover and utilize.\n" +
                        "\n" +
                        "Rolling with the punches is another key aspect to being a good Sage. Players can very easily find clever bypasses to your puzzle, or cheesy ways to kill all the mooks without risking themselves. This is okay. For that scenario at least, of course you should prevent this from happening again whether it be out of character discussion about the problem, or just planning for it to happen and countering it. If the game is interrupted by exploits, it is never a good thing. Don’t God mode the enemies to do this however, that’s as bad as railroading your players.\n" +
                        "\n" +
                        "So far, most of this advice is broadly applicable to all forms of roleplaying games, there are some specific things to be included to make a distinctly Legend of Zelda feel in the game. The video games have a pretty distinct hero vs villain theme throughout, but that doesn’t need to be included. Legend of Zelda is loved for it’s combination of action and adventure. You fight strange monsters with strange attacks that force you to find creative ways to deal with them. Like Stalfos that resurrect if their partner isn’t defeated in time, or octorock that require you to reflect their attack back at them, or any of the bosses. And between the fights, you deal with dangerous traps that test your cunning, and devious puzzles to test your wit.\n" +
                        "\n" +
                        "Enemies don’t need to be touched on much. Their generation is very simple and quick and their effect on the party should only be a mild drain on their resources rather than constant life or death struggles. Giving them various techniques and spells in cohesion with one another can easily give every fight a unique aspect unlike the previous encounters. Mid-Bosses should of course receive much more attention than your generic room-to-room mooks. Their battle style should reflect the theme of the dungeon somehow, and they usually guard the dungeons secondary treasure. Be careful to not let the Mid-Boss upstage the Dungeon Boss however.\n" +
                        "\n" +
                        "Dungeon Bosses are critical to Zelda style dungeons. They are the capstone of triumph over the dungeon and are the most difficult adversary the party will face in the entire dungeon. Their skills should be carefully defined and utilized, as well as the room they are encountered in. The Dungeon Boss should have a trick to beating them in a reliable way, but must also allow players to get creative, and be rewarded for their creativity. Just because the plan was for them to use fire arrows to melt the ice barriers doesn’t mean bombs won’t do it better. Every Dungeon Boss should be tailored to the dungeon it is guarding, thematically and mechanically.All of this is fairly standard fair for roleplaying games. The emphasis on puzzles is where the trickery for being the Sage comes in. There are a couple ways to approach puzzles in a pen and paper format. You can of course use traditional paper puzzles, such as disguised chess puzzles, riddles, and slide puzzles. Clever paths and hidden levers to change the area until everything falls into place is a more complex puzzle that can be used to gain access to certain areas.\n" +
                        "\n" +
                        "Mechanical puzzles can be the most intriguing however. Consider environmental effects during a multiple stage combat. Falling sand that inhibits movement, burning coals that damage you for not moving, sliding on wet ice, collapsing platforms, illusionary paths filled with traps, a vibrating membrane knocking everyone down, drifting rafts , flipping ice shelves, magnetic walls, flooding waterfalls, quicksand pits, lightning storms, burrowing wyrms, tumbling rocks, or a million other things. The key being to change the scenario in some unique way, often using recently acquired items to overcome these puzzles.\n" +
                        "\n" +
                        "In the end, creating a Legend of Zelda experience is about enjoying a quest that is about defeating monsters, solving puzzles, saving the day, roleplaying, and having a good time. The Sage needs to create a diverse world, and the players have to put their effort through as well.");


        List<RuleModel> ruleList = new ArrayList<>();
        ruleList.add(missionStatement);
        ruleList.add(howToBeASage);
//        mainPage.setRuleList(ruleList);
        appendRulesToPage(pageModelRepo, ruleList, mainPage);
//
//        PageModel coreMechanics = new PageModel("Core Mechanics");
//        coreMechanics.setPageTitle("Core Mechanics");
        PageModel coreMechanics = createNewPage(pageModelRepo, "Core Mechanics");
//
//        RuleModel theDice = new RuleModel("The Dice");
//        theDice.setRuleTitle("The Dice");
//        theDice.setSourceBook("Legend of Zelda Beta 3");
//        theDice.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
//        theDice.setChapterPage("ch.2, pg.12");
//        theDice.setRuleText("D6 dice pool. To make a check, roll a number of 6-sided dice equal to the sum of your ranks in the relevant attribute and skill, plus any additional dice you may receive from racial bonuses or demonstrating a particular Virtue. Each die that comes up 4 or higher is a success; the more successes you get, the more impressive your performance. Particularly difficult tasks may require multiple successes to accomplish.");
        RuleModel theDice = createNewRule(ruleModelRepo,
                "The Dice",
                "2", "11",
                "D6 dice pool. To make a check, roll a number of 6-sided dice equal to the sum of your ranks in the relevant attribute and skill, plus any additional dice you may receive from racial bonuses or demonstrating a particular Virtue. Each die that comes up 4 or higher is a success; the more successes you get, the more impressive your performance. Particularly difficult tasks may require multiple successes to accomplish.");
//
//        RuleModel dicePool = new RuleModel("The Dice Pool");
//        dicePool.setRuleTitle("The Dice Pool");
//        dicePool.setSourceBook("Legend of Zelda Beta 3");
//        dicePool.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
//        dicePool.setChapterPage("ch.2, pg.12");
//        dicePool.setRuleText("The Legend of Zelda RPG determines all chaotic and chance based challenges with the use of dice pools. An appropriate number of six sided dice, like the kind you can steal from monopoly, is rolled as determined by your character’s ability to perform in the challenge. The values of the dice have been remapped however, into a binary system, similar to a coin toss. 1’s, 2’s, and 3’s are all equally bad, essentially a 0. 4’s, 5’s, and 6’s are all equally good, essentially a 1 because they represent 1 success. This gives a 50/50 chance of rolling a success on each die. Unless this ratio is changed for some reason, any die can take the place of the six sided die because all platonic solids have an even number of sides. Heck, you could toss coins at the table and count the number of heads.\n" +
//                "\n" +
//                "Using a system like this creates a normal distribution of probability, so you can rely quite well on your dice as compared to other systems. A low skilled roll will be very granular and unpredictable, but as the character progresses and gets more dice to roll, statistics and probability set in to create bell curves. This means that while your average increases with the dice pool, you become more and more likely to roll near your average rather than wildly off in one direction or another.");
        RuleModel dicePool = createNewRule(ruleModelRepo,
                "The Dice Pool",
                "2", "11",
                "The Legend of Zelda RPG determines all chaotic and chance based challenges with the use of dice pools. An appropriate number of six sided dice, like the kind you can steal from monopoly, is rolled as determined by your character’s ability to perform in the challenge. The values of the dice have been remapped however, into a binary system, similar to a coin toss. 1’s, 2’s, and 3’s are all equally bad, essentially a 0. 4’s, 5’s, and 6’s are all equally good, essentially a 1 because they represent 1 success. This gives a 50/50 chance of rolling a success on each die. Unless this ratio is changed for some reason, any die can take the place of the six sided die because all platonic solids have an even number of sides. Heck, you could toss coins at the table and count the number of heads.\n" +
                        "\n" +
                        "Using a system like this creates a normal distribution of probability, so you can rely quite well on your dice as compared to other systems. A low skilled roll will be very granular and unpredictable, but as the character progresses and gets more dice to roll, statistics and probability set in to create bell curves. This means that while your average increases with the dice pool, you become more and more likely to roll near your average rather than wildly off in one direction or another.");

//
//        ruleList = new ArrayList<>();
//        ruleList.add(theDice);
//        ruleList.add(dicePool);
//        coreMechanics.setRuleList(ruleList);
        ruleList = new ArrayList<>();
        ruleList.add(theDice);
        ruleList.add(dicePool);
        appendRulesToPage(pageModelRepo, ruleList, coreMechanics);
//
//        PageModel subPage1 = new PageModel("Example Subpage 1");
//        subPage1.setPageTitle("Example Subpage 1");
//
//        PageModel subPage2 = new PageModel("Example Subpage 2");
//        subPage2.setPageTitle("Example Subpage 2");
//
//        PageModel subPage3 = new PageModel("Example Subpage 3");
//        subPage3.setPageTitle("Example Subpage 3");
//
//        List<PageModel> subPages = new ArrayList<>();
//        subPages.add(subPage1);
//        subPages.add(subPage2);
//        subPages.add(subPage3);
//
//        mainPage.setChildPages(subPages);
//
//        pageModelRepo.save(subPage1);
//        pageModelRepo.save(subPage2);
//        pageModelRepo.save(subPage3);
//        ruleModelRepo.save(missionStatement);
//        ruleModelRepo.save(howToBeASage);
//        ruleModelRepo.save(theDice);
//        ruleModelRepo.save(dicePool);
//        pageModelRepo.save(mainPage);
//        pageModelRepo.save(coreMechanics);

        PageModel stats = createNewPage(pageModelRepo, "Stats");
        RuleModel attributes = createNewRule(ruleModelRepo, "Attributes",
                "3", "12",
                "Attributes represent your character's general, basic abilities. Each Attribute has a minimum rank of 1 and a maximum rank of 5. A basic starting character has 2 ranks in each of two different attributes of their choice, and 1 rank in the rest. \n" +
                        "\n" +
                        "• Brawn represents your physical strength and might. \n" +
                        "\n" +
                        "\to If you have at least 4 points in Brawn, you can wield weapons 1 size category larger for no penalty \n" +
                        "\n" +
                        "• Agility represents your coordination and reflexes. \n" +
                        "\n" +
                        "\to If you have at least 3 points in Agility, you are not affected by poor footing (ie rubble and ice). If you have 5 points of Agility, your speed increases by an additional 2 meters (1 square). You lose this benefit if you're encumbered by heavy armor or objects. \n" +
                        "\n" +
                        "• Wits represents innate and intuitive mental faculties, such as creativity, cunning, and perceptiveness. \n" +
                        "\n" +
                        "\to If you have at least 3 points in Wits, you do not take the success range penalty on harmonics \n" +
                        "\n" +
                        "• Guts represents your determination, passion, and fortitude, both mental and physical. \n" +
                        "\to If you have at least 3 points in Guts, you automatically pass all fear based Composure rolls. If you have at least 5 points in Guts, all SP restoration is doubled for you \n" +
                        "\n" +
                        "• Smarts represents learned and rational mental faculties, such as acquired knowledge and logical reasoning. \n" +
                        "\to If you have at least 3 points in Smarts you can utilize Cascade Casting.");

        RuleModel skills = createNewRule(ruleModelRepo, "Skills",
                "3", "13",
                "Skills represent specific capabilities your character has learned through practice and training. Each skill starts at 0 and can be raised to a maximum rank of 5. Starting characters are given a point buy. Every point in the same skill costs its sum, so skill 1 costs 1, skill 2 costs 3, 3 6, 4 10 and so on. While each skill will generally be associated with a single attribute, the attribute used can vary depending on the situation, particularly for certain skills more than others. \n" +
                        "For example, running a race would always use Athletics, but the relevant attribute might be either Guts or Agility depending on whether it's a long-distance run or a shorter sprint. The skills are intended to be fairly broad and general, so that each skill has a fairly wide array of applicable uses. \n" +
                        "\n" +
                        "• Melee (B): Most all melee weapons, except those that fall under Heavy. Swords, axes, maces, spears, unarmed combat, etc. Brawn is typically the associated attribute for Melee skill checks. \n" +
                        "\n" +
                        "• Heavy (B): Big, heavy weapons that are slow and unwieldy, but pack a tremendous punch. Not only do Heavy weapons deal considerably more damage than other types, the force of their blows tends to make the enemy flinch. The Biggoron's sword and megaton hammer are examples of Heavy weapons. Brawn is pretty much always the associated attribute for Heavy skill checks. \n" +
                        "\n" +
                        "• Ranged (A): Ranged weapons, such as the bow, boomerang, and slingshot. Agility is usually the associated attribute for Ranged skill checks. \n" +
                        "\n" +
                        "• Shields (G): Exactly as the name suggests - use of shields, for both defensive and offensive purposes. Brawn is typically the associated attribute for Shields skill checks. \n" +
                        "\n" +
                        "• Spellcraft (S): Use of magic, whether spells in the conventional sense of powers inherent to your character through study or innate talent, or to invoke magical items like the Fire Rod or Bombos Medallion. Things that use this skill require MP. Smarts is always the associated attribute for Spellcraft skill checks. \n" +
                        "\n" +
                        "• Instruments (W): Making music, often to produce mystical effects, eg, playing the Song of Storms on the Ocarina of Time to make it rain). Wits is always the associated attribute for Instruments skill checks. Your singing is not magical. \n" +
                        "\n" +
                        "• Tools (B,A,S): A catch-all skill for all the miscellaneous items that don't quite fit any of the above categories, such as the spinner or beetle. The associated attribute for Tools skill checks varies widely depending on what kind of tool you're using. \n" +
                        "\n" +
                        "• Acrobatics (A): For feats of extraordinary reflexes and coordination, nimbly jumping about like a Sheikah. Agility is typically the associated attribute for Acrobatics skill checks. \n" +
                        "\n" +
                        "• Athletics (B,A,G): For more conventional feats of physical prowess, such as swimming, more straightforward leaps, running races, etc. Brawn, Agility, and Guts are all possible associated attributes for Athletics skill checks. \n" +
                        "\n" +
                        "• Riding (S): Handling a mount, such as a horse or Loftwing. Your rank in Riding is the highest amount of dice you can roll while riding a mount. It is also used to determine your ability to maneuver obstacles at high speed. \n" +
                        "\n" +
                        "• Stealth (A): For when you don't want to be noticed. This is your passive stealth score, before the various modifiers are applied for how you actually go about hiding yourself. \n" +
                        "\n" +
                        "• Perception (W): For when you want to notice something. Wits is always the associated attribute for Perception skill checks. These rolls are for something difficult to see, or to notice something you weren't actually looking for. Direct investigation should always be a success. \n" +
                        "\n" +
                        "• Survival (S): For gathering resources (such as cutting grass for hearts and rupees) and various other tasks, like fishing. \n" +
                        "\n" +
                        "• Lore (S): Knowing about things. Smarts is always the associated attribute for Lore skill checks. To increase the usefulness of this skill, it represents general learning instead of specific areas of knowledge. If for some reason your character would have advanced knowledge in an area, they wouldn't need to roll Lore in the first place. \n" +
                        "\n" +
                        "• Composure (W): The ability to keep hold of ones emotions, keeping a straight face, feigning interest, ignoring pain, and holding back tears are all uses for Composure; what you actually say and how It’s received is up to you and your Sage. ");

        RuleModel virtues = createNewRule(ruleModelRepo, "Virtues",
                "3", "15",
                "Virtues are a special stat, representing the three aspects of the Triforce. These aren't so much about what you do as how you do it. In order to add your rank in a Virtue to your dice pool, you have to do something in a way that demonstrates that Virtue. Virtues start at 0 and can be raised to a maximum of 3, but raising a Virtue is extremely difficult. A basic starting character has 1 rank in a single Virtue of their choice, and no ranks in the rest. \n" +
                        "\n" +
                        "• Power is associated with pure force. It is blunt and straightforward, not bothering with finicky matters of subtlety and finesse. It is aggressive and imposing. You'd add Power when your character has had enough of subtlety and goes to brute force a solution. When they get angry and decide the time has come to Rip And Tear. When they think a swift kick to the locked chest'll do the job faster than the delicacy of a lockpick. To everyone else you're brutish and grisly. To those who see it you have Power. \n" +
                        "\n" +
                        "• Wisdom is associated with contemplation and manipulation. It is refined and precise, preferring to take the time to analyze a situation rather than forcing its way through. It is cautious and discerning. You add Wisdom when you decide to act with clear planning. When you try to play smart and subtle. When rather than volleying arrows, you wait for the opportune moment to shoot. To everyone else you're overly cautious and slow. To those who see it you have Wisdom. \n" +
                        "\n" +
                        "• Courage is associated with heroism and a balanced approach with respect to the other two Virtues. It bridges the gap between Power and Wisdom - not as brutally aggressive as Power, but much more straightforward and action-oriented than Wisdom. It is persevering and straightforward. You add Courage when you're being daring and bold. When you take big risks, deal with your fears, or put yourself in harm's way for an ally. When the Deku bravely charges the Dodongo or the Kokiri challenges the Iron Knuckle to a duel. To everyone else you're crazy and reckless. To those who see it you have Courage. ");

        RuleModel heartsMagicStamina = createNewRule(ruleModelRepo, "Hearts, Magic, and Stamina",
        "3", "16",
                "Hearts function like hit points, with each heart being equivalent to 4 HP. Damage and health are measured in hearts or fractions thereof, using the shorthand terminology of #H (eg, 2H, 1+1/2H, etc). When you run out of hearts, you are down, but not dead. A character whose hearts are depleted has one \"Final Heart\"; only if the Final Heart is depleted does the character die, and the vast majority of enemies will leave a downed character alone until more active threats are dealt with. Hearts can be recovered through enemy drops, foraging (cutting grass, breaking pots, etc.), extended rest, and healing items/magic (such as fairies, potions, healing spells, etc.). \n" +
                        "\n" +
                        "Magic is used to power spells and magic items. Each such effect consumes a certain amount of magic power (MP), which is acquired in blocks of 4. A character can have a maximum of 60 MP (15 blocks). Recovering MP requires magic jars (obtained through enemy drops or potions), extended rest, or potions (or a similar effect). \n" +
                        "\n" +
                        "Stamina is mainly used to power special techniques, but is also needed for certain actions that any character can do (such as sprinting). Like MP, stamina is acquired in blocks of 4. Like magic, a character can have a maximum of 60 points of stamina (15 blocks). Stamina can be recovered in combat by giving up actions to rest. Each action restores 1 block. Outside of combat, you can easily recover all your stamina with a short break of only a minute or so. \n" +
                        "\n" +
                        "Each character starts with 3 hearts. A character's base magic is a number of blocks equal to 1+Wits - so, for instance, a character with 2 Wits would have 3 blocks of MP (12 points). Similarly, a character's base stamina is a number of blocks equal to 1+Guts. \n" +
                        "\n" +
                        "Fluff note: Hearts and magic are recovered in essentially the same way they are in the video game - by picking up items that must be used the moment you get them. Of course, this leads one to wonder why you couldn't just stockpile hearts and magic jars for when you really need them. If you're not content with merely handwaving the issue away, one explanation we've come up with in the course of working on this project is that hearts and magic jars are in fact crystallized deposits of life and magic energy, respectively. These crystalline forms are extremely delicate, and rapidly destabilize when touched. If the energy is not used immediately, it quickly dissipates into the environment.");

        ruleList = new ArrayList<RuleModel>();
        ruleList.add(attributes);
        ruleList.add(skills);
        ruleList.add(virtues);
        ruleList.add(heartsMagicStamina);
        appendRulesToPage(pageModelRepo, ruleList, stats);

        PageModel racials = createNewPage(pageModelRepo, "Racials");
        RuleModel racialStats = createNewRule(ruleModelRepo, "Racial Stats",
                "3", "17",
                "Many dozens of races have been introduced throughout the zelda franchise and this is by no means a complete list of them in any way. The most popular races have been represented here and the capacity to stat in more of the obscure races is included. These racials are not only for clearly player races, but also for enemy races as there is no bestiary aside from a list of example mooks. The rule of thumb for whether something is a mook or not has been whether it can think and if it can climb a ladder, the first being if it's suitable to be played as, the second to determine whether it could actually function in a dungeon. Standard move speed is 3.");

        RuleModel humanStats = createNewRule(ruleModelRepo, "Human Stats",
                "3", "17",
                "o Human, Hylian : Size Medium; acoustic alignment detection (whether they tend towards Power, Wisdom, Courage, or are forsaken by the Goddesses) \n" +
                        "\n" +
                        "o Human, Gerudo : Size Medium; ignore mild environmental hazards, only female (no Ganondorfs as players) \n" +
                        "\n" +
                        "o Human, Shiekah : Size Medium; may ignore adjacent and field of view penalties to stealth \n" +
                        "\n" +
                        "o Human, Termina : Size Medium; +1 to all rolls involving Narrative Magic \n" +
                        "\n" +
                        "o Human Imp, Skull Kid : Size Small; +1 to instruments, prank cantrip for -1 mp (magically pranking someone nets 1 mana back)");

        RuleModel alliedStats = createNewRule(ruleModelRepo, "Allied Race Stats",
                "3", "17",
                "o Zora : Size Medium; Water breathing, hydrodynamic, adjustable bouyancy, electric sense (Can detect and glean information from nearby electric currents), double damage from Ice and Fire \n" +
                        "\n" +
                        "o Deku : Size Small; Water walking for no more than 1 turn in a row, wood sense (can detect and glean information from nearby wood), Evolving Tech Spit Attack, Evolving Tech Burrowing, immediate drowning at double damage, double fire damage. \n" +
                        "\t(Note: Player Dekus are not deku scrubs, those are merely enemies. Player dekus are the older dekus that have woody bodies and limbs. The kind that are often shopkeepers and actually help Link from time to time.)\n" +
                        "\n" +
                        "o Kokiri : Size Small; personal fairy with at will Clairvoyance, search checks are twice as bountiful, permanent child, not supposed to leave The Great Deku Tree \n" +
                        "\n" +
                        "o Goron : Size Large; half environmental damage, Evolving Tech Goron Roll, stone sense (Can detect and glean information from nearby stone), eats rocks; -5 bouyancy, 2 movement \n" +
                        "\n" +
                        "o Twili : Size Medium; can Warp for 1 mp during Twilight, fatigued in direct sunlight unless wearing darkness enchanted armor, can see in the dark \n" +
                        "\n" +
                        "o Korok : Size Small; Evolving Tech Flight, double fire damage, tree themed Stalagmite for 4 mp (make no canonical sense, nor combat sense) \n" +
                        "\t(Note: Canonically, Koroks are what the Kokiri became in the Era of the Great Sea, but that would make one or the other unplayable in the same campaign, keep if you want to)\n" +
                        "\n" +
                        "o Rito : Size Small; Evolving Tech Flight, wind sense* (Can detect and glean information from passing wind) \n" +
                        "\n" +
                        "o Subrosians : Size Small; Immune to fire, double damage and stun from Ice, must wear a burqa (light weakness?) ");

        RuleModel enemyStats = createNewRule(ruleModelRepo, "Enemy Race Stats",
                "3", "18",
                "o Construct : Size Large; ignore all environmental hazards, -5 bouyancy, 2 movement, +1/4H damage from imbued Light \n" +
                        "\n" +
                        "o Garo : Size Small; -1H at all times, upon the destruction of their clothing, their spirit body (1H, incorporeal, invisible) is freed to escape and possess a new set of clothing which slowly morphs back into Garo Robes \n" +
                        "\n" +
                        "o Goriya : Size Medium; +1 to Presence when trading \n" +
                        "\n" +
                        "o Blins : Size Small to Medium; Move Speed 4, optional increase from Small to Medium, optional increase to Large and 3 move speed \n" +
                        "\n" +
                        "o Wizzrobe : Size Medium; Jaunt for 1 mp \n" +
                        "\n" +
                        "o Stalfos : Size Medium; Guardian for 0 sp, permanent Soulbond with one other Stalfos, immune to environmental damage \n" +
                        "\n" +
                        "o Lizalfos : Size Medium; Guardian for 0 sp, Double Damage from Ice, Half Damage from Fire \n" +
                        "\n" +
                        "o Mook : Any Size; pick a number, that is their dice pool for everything, their number of hearts stamina and mana, and can have up to that many techs or spells");

        ruleList = new ArrayList<>();
        ruleList.add(racialStats);
        ruleList.add(humanStats);
        ruleList.add(alliedStats);
        ruleList.add(enemyStats);
        appendRulesToPage(pageModelRepo, ruleList, racials);
        List<PageModel> pageModelList = new ArrayList<>();
        pageModelList.add(racials);
        appendSubpageToPage(pageModelRepo, pageModelList, stats);

        PageModel characterCreation = createNewPage(pageModelRepo,"Character Creation");
        PageModel characterAdvancement = createNewPage(pageModelRepo, "Character Advancement");
        pageModelList = new ArrayList<>();
        pageModelList.add(characterAdvancement);
        appendSubpageToPage(pageModelRepo, pageModelList, characterCreation);

        RuleModel basicCharacterCreation = createNewRule(ruleModelRepo, "Basic Character Creation",
                "5", "20",
                "• Choose a race \n" +
                        "• Set two attributes to Rank 2 and the other three attributes to Rank 1 \n" +
                        "• All characters start with three (3) hearts \n" +
                        "• All characters start with one (1) plus Guts blocks of Stamina \n" +
                        "• All characters start with one (1) plus Wits blocks of Mana \n" +
                        "• Assign fifteen (15) skill points via point buy [Rank 1 costs 1 skill point. Rank 2 costs 2 skill points, plus the cost to raise the skill to Rank 1 (i.e. 1 more skill point). A Rank 2 skill costs, total, 3 skill points.] \n" +
                        "• Sage sets the starting rupees, 200 is normal \n" +
                        "• Refer to pricing on the tables to buy \n" +
                        "• Training cost is 20/sp, 30/mp, 20/action (action cost is only for songs) \n" +
                        "• Details details details \n" +
                        "• ???? \n" +
                        "• Adventure!");

        ruleList = new ArrayList<>();
        ruleList.add(basicCharacterCreation);
        appendRulesToPage(pageModelRepo, ruleList, characterCreation);

        RuleModel basicCharacterAdvancementRewards = createNewRule(ruleModelRepo, "Basic Character Advancement: Rewards",
                "5", "22",
                "• Gift of the Goddess : Increase your virtue by 1, all hearts are restored. Granted just before the Final Boss. \n" +
                        "• Powerful Essence : Increase 1 Attribute. Dropped by Dungeon Bosses. \n" +
                        "• Full Heart : Permanently add 1 Heart, or 1 block of Mana, or 1 block of Stamina. Dropped by Dungeon Bosses. \n" +
                        "• Piece of Heart : Collect 4 to create a Full Heart. Granted by side quests. \n" +
                        "• Weak Essence : Increase two different Skills by 1. Dropped by Mini\u0002Bosses \n" +
                        "• Artifact : An important item. Granted after the Mini-Boss.");

        RuleModel basicCharacterAdvancementForeword = createNewRule(ruleModelRepo, "Basic Character Advancement: Foreword",
                "5", "20",
                "We would like to make this system entirely XP-less -- that is, rather than spending some kind of metagame resource to improve your character (as is the case in most every RPG), characters improve through in-game rewards. While this will add a bit more for the Sage to do, it strongly supports our goal of making a system with uniquely Legend-of-Zelda-style gameplay. \n" +
                        "\n" +
                        "Of course, one of the most important means of character advancement is acquiring items. In order to advance to new challenges, you'll need to expand your repertoire of tools for handling them -- just like in the video games. Items are most prominently found in dungeons, and the item found in a dungeon is usually crucial for handling that dungeon's puzzles and boss. They also can be obtained in the overworld from side quests and the like. Note that \"items\" need not necessarily be physical objects -- they might be spells or songs learned from a mentor or ancient writing. Anything that adds a totally new capability that is vital for characters to handle puzzles and similar obstacles is effectively an \"item\". \n" +
                        "\n" +
                        "Another important means of advancement is the learning of techniques. Techniques are special abilities and tricks that your character learns through practice. Like items, they typically add entirely new abilities to your repertoire, rather than merely improving your stats; however, unlike items, techniques rarely play a pivotal role in solving puzzles (though this is not to say that they can't play such a role occasionally). Rather, techniques help to personalize and flesh out your character's capabilities, adding variety and style to how you do things. Techniques are often combat-oriented, in contrast to items, which are typically puzzle-oriented. Techniques would typically be learned from mentors (such as the Hero's Spirit in Twilight Princess), but could also be learned from studying written instructions (such as the Tiger Scrolls in Minish Cap) or from other sources entirely --whatever the Sage feels is appropriate. \n" +
                        "\n" +
                        "Hearts, as you might expect, should be increased in essentially the same fashion as they are in the video games -- from Heart Containers dropped by defeated bosses, and from collecting Pieces of Heart. Each new heart obtained (whether from a defeated boss or Pieces of Heart) should benefit each party member equally. \n" +
                        "\n" +
                        "The Sage should also provide opportunities for characters to acquire additional blocks of magic power and stamina in-game. The form this takes is entirely up to the Sage; you might use very abstract methods as is done for hearts, or the intervention of a powerful magical being (such as a Great Fairy's blessing or the Mad Batter's \"curse\", which double your magic meters in the video games that use them), or a powerful potion brewed by a witch, or perhaps even intense training under a suitable mentor to increase your reserves of strength. The number of extra blocks of these resources provided to a character should not exceed twice that character's rank in the associated attribute for that resource -- for instance, the Sage shouldn't give a character with 3 Guts more than 6 additional blocks of Stamina through in-game sources. However, Sages should be fairly generous in making extra blocks available, not shying away from allowing players to reach this upper limit. The pace at which these increases are provided is up to the Sage -- some may find it easier to only rarely give out many blocks at once (similar to the one-time doubling of the magic meter in the video games), while others may prefer the smoother progression afforded by providing one block at a time spread out regularly over the course of the campaign. \n" +
                        "\n" +
                        "Extra blocks of magic and stamina may be distributed to the party as a whole (in which case the amount of blocks given should be determined by the average relevant attribute value of all party members) or individually (in which case the number of blocks given can be determined on a character-by-character basis). If using individual distribution, characters should not be permitted to give extra blocks they obtain personally to other party members -- in other words, the whole party should not be able to go out and, for instance, each get a potion that boosts MP capacity and all give their potions to the party's mage. \n" +
                        "\n" +
                        "Finally, of course, there's increasing your stats -- your attributes, skills, and Virtues. This too must be accomplished through in-game action. Improving your rank in a skill might require studying under a suitable expert in that field. Improving an attribute might take intensive trainingunder a strict coach, or perhaps a magical infusion of ability from a potion or Great Fairy. Improving a Virtue would almost always require some kind of intervention on the part of a powerful supernatural entity -- perhaps even the Virtue's patron Goddess herself! Increasing stats should typically involve a side quest or \"minigame\" of sorts, determined by the Sage. A mentor might require you to overcome some trial to prove your worth before training you; finding a reclusive guru may be a challenge in itself; a witch might need you to gather ingredients for her to make you an attribute-boosting potion; a Great Fairy might require you to prove your Virtue by undertaking some grand endeavour before blessing you with greater strength in that area; and so forth. Increasing skills would require relatively easy challenges -- in fact, the Sage may simply require nothing more than the payment of a training fee in rupees at a local guild, if they don't want to spend time on something so trivial. \n" +
                        "Improving an attribute is a slightly more significant boost, and requires a bit more effort. Improving a Virtue is a momentous task indeed, requiring tremendous effort. While it would be reasonable to expect a character to hit the maximum rank of 5 in their primary attribute and skills by the end of an extended campaign, maxing out a Virtue should be reserved for only the most truly epic campaigns.");

        ruleList = new ArrayList<>();
        ruleList.add(basicCharacterAdvancementRewards);
        ruleList.add(basicCharacterAdvancementForeword);
        appendRulesToPage(pageModelRepo, ruleList, characterAdvancement);

        List<CharacterSheet> char1List = new ArrayList<>();
        CharacterSheet char1a = CharacterSheetService.generateDefaultSheet();
        char1a.setSheetName("char1a");
        char1a.setCharacterName("Sample Name");
        char1a.setGreenRupees(3);
        CharacterSheet char1b = CharacterSheetService.generateDefaultSheet();
        char1b.setSheetName("char1b");
        CharacterSheet char1c = CharacterSheetService.generateDefaultSheet();
        char1c.setSheetName("char1c");
        char1a = characterSheetRepo.save(char1a);
        char1b = characterSheetRepo.save(char1b);
        char1c = characterSheetRepo.save(char1c);
        char1List.add(char1a);
        char1List.add(char1b);
        char1List.add(char1c);

        PlayerAccount player1 = new PlayerAccount("Tom", "$2a$10$Y9SZd9XS./XQmTGRsMFQW.COgZnL0Sc9ZIcWbbbanUMPxoTP2e4lm", char1List);
        player1 = playerAccountRepo.save(player1);
        log.warn("Player1 is: " + player1);
        PlayerAccount player2 = new PlayerAccount("Dick", "$2a$10$Y9SZd9XS./XQmTGRsMFQW.COgZnL0Sc9ZIcWbbbanUMPxoTP2e4lm");
        playerAccountRepo.save(player2);
        PlayerAccount player3 = new PlayerAccount("Harry", "$2a$10$Y9SZd9XS./XQmTGRsMFQW.COgZnL0Sc9ZIcWbbbanUMPxoTP2e4lm");
        playerAccountRepo.save(player3);

        authGroupRepo.save(new AuthGroup("Tom", "ROLE_ADMIN"));
        authGroupRepo.save(new AuthGroup("Richard", "ROLE_USER"));
        authGroupRepo.save(new AuthGroup("Harry", "ROLE_USER"));
    }

    private static RuleModel createNewRule(IRuleModelRepo ruleModelRepo, String ruleName, String ruleChapter, String rulePage, String ruleText){
        RuleModel newRule = new RuleModel(ruleName);
        newRule.setRuleTitle(ruleName);
        newRule.setSourceBook("Legend of Zelda Beta 3");
        newRule.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
        newRule.setChapterPage("ch."+ruleChapter+", p."+rulePage);
        newRule.setRuleText(ruleText);
        ruleModelRepo.save(newRule);
        return newRule;
    }

    private static PageModel createNewPage(IPageModelRepo pageModelRepo, String pageName){
        PageModel newPage = new PageModel(pageName);
        newPage.setPageTitle(pageName);
        pageModelRepo.save(newPage);
        return newPage;
    }

    private static void appendRulesToPage(IPageModelRepo pageModelRepo, List<RuleModel> rules, PageModel page){
        if (page.getRuleList() == null) {
            page.setRuleList(new ArrayList<RuleModel>());
        }

        for (RuleModel rule: rules) {
            page.getRuleList().add(rule);
        }

        pageModelRepo.save(page);
    }

    private static void appendSubpageToPage(IPageModelRepo pageModelRepo, List<PageModel> subPages, PageModel page) {
        if (page.getChildPages() == null) {
            page.setChildPages(new ArrayList<PageModel>());
        }

        for (PageModel subPage: subPages) {
            page.getChildPages().add(subPage);
        }

        pageModelRepo.save(page);
    }
}























package org.perscholas.lozb3_srd;

import lombok.extern.java.Log;
import org.perscholas.lozb3_srd.dao.ICharacterSheetRepo;
import org.perscholas.lozb3_srd.dao.IPageModelRepo;
import org.perscholas.lozb3_srd.dao.IPlayerAccountRepo;
import org.perscholas.lozb3_srd.dao.IRuleModelRepo;
import org.perscholas.lozb3_srd.models.PageModel;
import org.perscholas.lozb3_srd.models.RuleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Log
@Transactional
public class AppRunner implements CommandLineRunner {
    ICharacterSheetRepo characterSheetRepo;
    IPageModelRepo pageModelRepo;
    IPlayerAccountRepo playerAccountRepo;
    IRuleModelRepo ruleModelRepo;

    @Autowired
    public AppRunner(ICharacterSheetRepo characterSheetRepo, IPageModelRepo pageModelRepo, IPlayerAccountRepo playerAccountRepo, IRuleModelRepo ruleModelRepo) {
        this.characterSheetRepo = characterSheetRepo;
        this.pageModelRepo = pageModelRepo;
        this.playerAccountRepo = playerAccountRepo;
        this.ruleModelRepo = ruleModelRepo;
    }

    // TODO: Override the run() method to generate some basic data for the app to test with
    @Override
    public void run(String... args) {
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("Adding a main page with sql statements.");
        PageModel mainPage = new PageModel("Main Page");
        mainPage.setPageTitle("Main Page");

        RuleModel missionStatement = new RuleModel("Mission Statement");
        missionStatement.setRuleTitle("Mission Statement");
        missionStatement.setSourceBook("Legend of Zelda Beta 3");
        missionStatement.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
        missionStatement.setChapterPage("ch.1, pg.3");
        missionStatement.setRuleText("This system is intended to accomplish three main goals:\n" +
                "\n" +
                "     1. Make a Legend of Zelda RPG, not a Legend of Zelda flavored RPG : The core mission statement of this system is to make a game that captures the characteristic style of gameplay that the Legend of Zelda video games are known for. This primarily entails a central emphasis on acquired items as the primary determiner of character capabilities, and a prominent presence of puzzles requiring specific items to solve. Combat, particularly boss battles, should have a puzzle-like aspect as well. And of course, all the classic LoZ items and races and such should be represented for use in games. It's not sufficient to merely have a system capable of incorporating these elements; it should be specifically geared to promote a uniquely and recognizably Legend-of-Zelda style of play.\n" +
                "\n" +
                "     2. Synthesize and expand on the video games, don't merely replicate them : While emulating the characteristic style of the Zelda games is the #1 priority, that doesn't mean we should limit ourselves to only the things you can do in those games. Any archetype that would reasonably fit into any of the Zelda settings should be feasible; not all PCs will be Hylian sword-and-boarders. The beauty of pen-and-paper RPGs is that they aren't limited by the same technical constraints that bind video games, and the Zelda series has very rich settings with lots stuff to work with; we should be free to let our imaginations run a bit wild. Likewise, unless it would add excessive complexity to the core of the system or threatens to render an item utterly redundant, there's no harm in allowing characters to do things that should reasonably be possible but can't be done in the video games. (It's important to note here that even if an item's original purpose in a given game is rendered moot by allowing a certain action, that doesn't mean the item can't be slightly adapted to still have a purpose. For instance, it would be reasonable to allow all characters to swim, barring conflicting racial traits such as a Goron's density, but that doesn't mean you can't still have a use for stuff like the Zora's Flippers or Zora Armor.)\n" +
                "\n" +
                "     3. Simplicity and Accessibility : We want this game to be easy to learn and easy to play, even for Zelda fans who've never played a tabletop game before. Of course, there is a point of diminishing returns where trimming down the rules hurts the system's robustness more than it improves ease of use, and we want to avoid that, but as a rule of thumb, keep it simple.");

        RuleModel howToBeASage = new RuleModel("How To Be A Sage");
        howToBeASage.setRuleTitle("How To Be A Sage");
        howToBeASage.setSourceBook("Legend of Zelda Beta 3");
        howToBeASage.setSourceHref("http://www.mediafire.com/file/7723dfl07gw3jc7/Legend_of_Zelda_RPG_Beta_3.pdf/file");
        howToBeASage.setChapterPage("ch.2, pg.5");
        howToBeASage.setRuleText("This system was designed with the goal of bringing new players into the hobby of pen and paper roleplaying. As such, many mechanical choices were made to minimize the workload on the player, often at the expense of the Sage. But don’t fret, this section here is a quick rundown of how to run this system in a fun and engaging manner while keeping your players going. So first, some terminology.\n" +
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
        mainPage.setRuleList(ruleList);
        ruleModelRepo.save(missionStatement);
        ruleModelRepo.save(howToBeASage);
        pageModelRepo.save(mainPage);
    }
}

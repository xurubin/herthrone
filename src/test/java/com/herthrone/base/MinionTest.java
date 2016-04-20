package com.herthrone.base;

import com.herthrone.Constants;
import com.herthrone.GameManager;
import com.herthrone.card.factory.ActionFactory;
import com.herthrone.card.factory.EffectFactory;
import com.herthrone.card.factory.MinionFactory;
import com.herthrone.configuration.ConfigLoader;
import com.herthrone.configuration.MinionConfig;
import com.herthrone.exception.CardNotFoundException;
import com.herthrone.exception.MinionNotFoundException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Collections;

/**
 * Created by yifeng on 4/15/16.
 */
public class MinionTest extends TestCase {

  private static final String YETI = "Chillwind Yeti";

  private Hero hero1;
  private Hero hero2;
  private Container<BaseCard> hand1;
  private Container<BaseCard> hand2;
  private Container<BaseCard> deck1;
  private Container<BaseCard> deck2;
  private Container<Minion> board1;
  private Container<Minion> board2;
  private Container<Secret> secrets1;
  private Container<Secret> secrets2;
  private Battlefield battlefield1;
  private Battlefield battlefield2;

  private ActionFactory armorUpActionGenerator1;
  private ActionFactory armorUpActionGenerator2;
  private EffectFactory effectFactory1;
  private EffectFactory effectFactory2;
  private MinionFactory minionFactory1;
  private MinionFactory minionFactory2;

  private Minion minion1;
  private Minion minion2;

  private GameManager gm;

  @Before
  public void setUp() throws FileNotFoundException, CardNotFoundException {
    this.gm = new GameManager(Constants.Hero.GULDAN, Constants.Hero.GULDAN, Collections.emptyList(), Collections.emptyList());
    this.hero1 = this.gm.getHero1();
    this.hero2 = this.gm.getHero2();
    this.hand1 = this.gm.getHand1();
    this.hand2 = this.gm.getHand2();
    this.deck1 = this.gm.getDeck1();
    this.deck1 = this.gm.getDeck2();
    this.board1 = this.gm.getBoard1();
    this.board2 = this.gm.getBoard2();
    this.secrets1 = this.gm.getSecrets1();
    this.secrets2 = this.gm.getSecrets2();
    this.battlefield1 = this.gm.getBattlefield1();
    this.battlefield2 = this.gm.getBattlefield2();

    this.minionFactory1 = new MinionFactory(this.battlefield1);
    this.minionFactory2 = new MinionFactory(this.battlefield2);
    this.effectFactory1 = new EffectFactory(this.minionFactory1, this.battlefield1);
    this.effectFactory2 = new EffectFactory(this.minionFactory2, this.battlefield2);

    this.minion1 = this.minionFactory1.createMinionByName(MinionTest.YETI);
    this.minion2 = this.minionFactory1.createMinionByName(MinionTest.YETI);
  }

  @Test
  public void testMinionStats() throws FileNotFoundException, MinionNotFoundException {
    MinionConfig config = ConfigLoader.getMinionConfigByName(MinionTest.YETI);
    assertEquals(config.getHealth(), this.minion1.getHealthAttr().getVal());
    assertEquals(config.getHealth(), this.minion2.getHealthAttr().getVal());
  }
}



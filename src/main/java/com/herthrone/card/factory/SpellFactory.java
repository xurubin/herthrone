package com.herthrone.card.factory;

import com.herthrone.base.Attribute;
import com.herthrone.base.Battlefield;
import com.herthrone.base.Minion;
import com.herthrone.base.Spell;

/**
 * Created by yifeng on 4/14/16.
 */
public class SpellFactory {

  private final Battlefield battlefield;

  public SpellFactory(final Battlefield battlefield) {
    this.battlefield = battlefield;
  }

  public Spell createSpellByName(final String name) {
    // TODO:
    return new Spell() {
      @Override
      public String getCardName() {
        return null;
      }

      @Override
      public String getType() {
        return null;
      }

      @Override
      public Attribute getCrystalManaCost() {
        return null;
      }

      @Override
      public void cast(Minion creature) {

      }
    };
  }
}

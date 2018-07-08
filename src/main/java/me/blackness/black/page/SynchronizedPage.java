package me.blackness.black.page;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;

import me.blackness.black.Page;

import java.util.ArrayList;
import java.util.List;

/*
       .                                                    .
    .$"                                    $o.      $o.  _o"
   .o$$o.    .o$o.    .o$o.    .o$o.   .o$$$$$  .o$$$$$ $$P  `4$$$$P'   .o$o.
  .$$| $$$  $$' $$$  $$' $$$  $$' $$$ $$$| $$$ $$$| $$$ ($o  $$$: $$$  $$' $$$
  """  """ """  """ """  """ """  """ """  """ """  """  "   """  """ """  """
.oOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOo.
  ooo_ ooo ooo. ... ooo. ... ooo.  .. `4ooo.  .`4ooo.   ooo. ooo. ooo ooo.  ..
  $$$"$$$$ $$$| ... $$$| ... $$$$$$ ..    "$$o     "$$o $$$| $$$| $$$ $$$|   .
  $$$| $$$ $$$|     $$$|     $$$|     $$$: $$$ $$$: $$$ $$$| $$$| $$$ $$$|
  $$$| $$$ $$$| $o. $$$| $o. $$$| $o. $$$| $$$ $$$| $$$ $$$| $$$| $$$ $$$| $.
  $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$| $$$ $$$| $o.
  $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$ $$$| $$$| $$$ $$$| $$$
  $$$| $$$  $$. $$$  $$. $$$  $$. $$$ $$$| $$$ $$$| $$$ $$$| $$$| $$$  $$. $$$
  $$$: $P'  `4$$$Ü'__`4$$$Ü'  `4$$$Ü' $$$$$P'  $$$$$P'  $$$| $$$: $P' __`4$$$Ü'
 _ _______/∖______/  ∖______/∖______________/|________ "$P' _______/  ∖_____ _
                                                        i"  personinblack
                                                        |
 */

/**
 * synchronize decorator for any page.
 *
 * @see Page
 */
public class SynchronizedPage implements Page {
    private final ChestPage base;
    private final List<Player> cache = new ArrayList<>();

    /**
     * ctor.
     *
     * @param base the page to make synchronize
     */
    public SynchronizedPage(final ChestPage base) {
        this.base = base;
    }

    @Override
    public void showTo(final Player player) {
        base.showTo(player);
        if (!cache.isEmpty()) {
            player.openInventory(cache.get(0).getOpenInventory().getTopInventory());
        }
        cache.add(player);
    }

    @Override
    public void handleClose(final InventoryCloseEvent event) {
        base.handleClose(event);
        cache.remove(event.getPlayer());
    }

    @Override
    public void update(final Object argument) {
        base.update(argument);
    }

    /**
     * {@inheritDoc}
     *
     * @deprecated because this is against oop.
     */
    @Override
    @Deprecated
    public Inventory getInventory() {
        return base.getInventory();
    }

    @Override
    public void accept(final InventoryInteractEvent event) {
        base.accept(event);
    }
}

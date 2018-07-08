package com.slamtheham.ultracore.menu;

import me.blackness.black.Element;
import me.blackness.black.Page;
import me.blackness.black.Pane;
import me.blackness.black.page.ChestPage;
import me.blackness.black.page.SynchronizedPage;
import me.blackness.black.page.TSafePage;
import me.blackness.observer.Target;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class UltraMenu {

    private String title;
    private Integer size;

    private Page page;
    private List<Pane> panes;

    public UltraMenu(String title, Integer size) {
        this.title = title;
        this.size = size;
        this.panes = new ArrayList<>();
    }

    public UltraMenu(String title, Integer size, Pane... panes) {
        this.title = title;
        this.size = size;
        this.panes = Arrays.asList(panes);
    }

    public boolean addElement(Integer paneid, Element element) {
        if (!hasPane(paneid)) return false;
        return panes.get(paneid).add(element);
    }

    public Element[] addElements(Integer paneid, Element... elements) {
        if (!hasPane(paneid)) return null;
        return panes.get(paneid).add(elements);
    }

    public void fillElement(Integer paneid, Element element) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).fill(element);
    }

    public void fillElement(Integer paneid, Element... elements) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).fill(elements);
    }

    public void insertElement(Integer paneid, Element element, int locX, int locY, boolean shift) throws IllegalArgumentException {
        if (!hasPane(paneid)) return;
        panes.get(paneid).insert(element, locX, locY, shift);
    }

    public void clear(Integer paneid) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).clear();
    }
    
    public void replaceAll(Integer paneid, Element... elements) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).replaceAll(elements);
    }

    public void remove(Integer paneid, int locX, int locY) throws IllegalArgumentException {
        if (!hasPane(paneid)) return;
        panes.get(paneid).remove(locX, locY);
    }

    public void subscribe(Integer paneid, Target<Object> target) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).subscribe(target);
    }

    public boolean contains(Integer paneid, ItemStack icon) {
        if (!hasPane(paneid)) return false;
        return panes.get(paneid).contains(icon);
    }

    public void accept(Integer paneid, InventoryInteractEvent event) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).accept(event);
    }

    public void displayOn(Integer paneid, Inventory inventory) {
        if (!hasPane(paneid)) return;
        panes.get(paneid).displayOn(inventory);
    }
    
    public boolean hasPane(Integer paneid) {
        return panes.get(paneid) != null;
    }
        
    public void addPane(Pane pane) {
        panes.add(pane);
    }

    public void removePane(Integer id) {
        panes.remove(id);
    }

    public Page buildChest() {
        page = new ChestPage(title, size, panes.toArray(new Pane[0]));
        return page;
    }

    public Page buildSafeChest() {
        page = new TSafePage(buildChest());
        return page;
    }

    public Page buildSyncChest() {
        page = new SynchronizedPage(((ChestPage)buildChest()));
        return page;
    }

    public void showTo(Player player) {
        page.showTo(player);
    }

    public void showToAll(Player... players) {
        Arrays.stream(players).forEach(this::showTo);
    }

    public void closeView(Player player) {
        player.closeInventory();
    }

    public Page getPage() {
        return page;
    }

    public List<Pane> getPanes() {
        return panes;
    }
}

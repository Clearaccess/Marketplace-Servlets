package dao;

import to.Item;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public interface ItemDAO {
    long insert(Item item);
    void update(Item item);
    void delete(Item item);
    Item getById(long id);
    ArrayList<Item> getItemsBySubstr(String substr);
    ArrayList<Item> getItemsBySellerId(long userId);
    ArrayList<Item> getAll();
}

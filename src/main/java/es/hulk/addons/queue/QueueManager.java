package es.hulk.addons.queue;

import me.joeleoli.portal.shared.queue.Queue;
import org.bukkit.entity.Player;

public class QueueManager {

    public boolean inQueue(Player p) {
        Queue queue = Queue.getByPlayer(p.getUniqueId());
        if (queue != null) {
            return true;
        } else {
            return false;
        }
    }

    public String getQueueIn(Player p) {
        Queue queue = Queue.getByPlayer(p.getUniqueId());
        return queue.getName();
    }

    public int getPosition(Player p) {
        Queue queue = Queue.getByPlayer(p.getUniqueId());
        return queue.getPosition(p.getUniqueId());
    }


    public int getInQueue(String queue) {
        Queue queue1 = Queue.getByName(queue);
        return queue1.getPlayers().size();
    }
}

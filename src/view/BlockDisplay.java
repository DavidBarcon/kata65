package view;

import model.Block;

public interface BlockDisplay extends Block.Observer{
    void display(Block block);
    Block block();
}

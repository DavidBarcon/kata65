/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Block;

/**
 *
 * @author david
 */
public class LeftCommand implements Command{
    private final Block block;
    
    public LeftCommand(Block block){
        this.block = block;
    }
    
    @Override
    public void execute() {
        block.left();
    }
    
}

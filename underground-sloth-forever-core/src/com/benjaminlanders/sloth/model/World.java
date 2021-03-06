package com.benjaminlanders.sloth.model;


public class World
{
	public Block[] blocks, vines;
	public Apple apple;
	public World(String file)
	{
		String[] types = file.split("=");
		String[] blocks = types[0].split("\n");
		String[] vines =  types[1].split("\n");
		this.blocks = loadBlocks(blocks);
		this.vines = loadBlocks(vines);
		this.apple = new Apple(types[2].split(","));
		
	}
	public static Block[] loadBlocks(String[] blocks)
	{
		Block[] temp = new Block[blocks.length];
		for(int i = 0; i < blocks.length;i++)
		{
			temp[i] = loadBlock(blocks[i]);
		}
		return temp;
		
	}
	public static Block loadBlock(String block)
	{
		String[] temp = block.split(",");
		return new Block(Float.parseFloat(temp[0]),Float.parseFloat(temp[1]),Float.parseFloat(temp[2]),Float.parseFloat(temp[3]));
	}
}

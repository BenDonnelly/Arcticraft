package net.arcticraft.util;

import org.lwjgl.util.vector.Vector3f;

public class VectorUtils
{
	/** Square root quick lookup for faster generation */
	static float[] sqrt = new float[100];

	public static void init()
	{
		for (int i = 0; i < sqrt.length; i++)
		{
			sqrt[i] = (float) Math.sqrt((double) i);
		}
	}

	public static float distance(Vector3f a, Vector3f b)
	{
		float distX = b.x - a.x;
		float distY = b.y - a.y;
		float distZ = b.z - a.z;

		return sqrt[(int) ((distX * distX) + (distY * distY) + (distZ * distZ))];
	}

	public static float distance(Vector3f a, float xb, float yb, float zb)
	{
		float distX = xb - a.x;
		float distY = yb - a.y;
		float distZ = zb - a.z;

		return sqrt[(int) ((distX * distX) + (distY * distY) + (distZ * distZ))];
	}
}

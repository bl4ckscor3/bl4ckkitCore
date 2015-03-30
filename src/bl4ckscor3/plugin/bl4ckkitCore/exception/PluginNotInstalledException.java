package bl4ckscor3.plugin.bl4ckkitCore.exception;

public class PluginNotInstalledException extends Exception
{
	private static final long serialVersionUID = 2061097222301896974L;

	/**
	 * Gets called if a plugin could not be found when trying to get its value.
	 * 
	 * @param name - The plugin involved
	 */
	public PluginNotInstalledException(String name)
	{
		super(name + " is not installed. This is a serious issue and should be resolved as soon as possible.");
	}
}

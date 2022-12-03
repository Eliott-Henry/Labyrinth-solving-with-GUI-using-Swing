package maze;

/**  Une erreur a eu lieu pendant la lecture d'un fichier texte d'un labyrinthe
 * @author Eliott Henry
 */

public class MazeReadingException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private String message;
	
	/** Donne des informations sur la localisation et la nature de l'erreur levée
	 * @param fileName adresse du fichier
	 * @param lineNo numéro de ligne de l'erreur dans le fichier
	 * @param message nature de l'erreur
	 */
	public MazeReadingException (String fileName, int line, String message)
	{
		super("Erreur détectée pendant la lecture du labyrinthe dans " + fileName + "(" + line + ") : " + message);
		this.message = message;
	}
	
	/** Retourne le message d'erreur
	 * @return message d'erreur
	 */
	public String getMessage() {
		return message;
	}
}

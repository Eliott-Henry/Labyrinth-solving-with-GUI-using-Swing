# Explication de l'ex�cution du labyrinthe  :

## Types de case

- W : case de mur
- E : case vide
- D : case de d�part. Il ne peut en avoir qu'une
- A : case d'arriv�e. Il ne peut en avoir qu'une
- P : case de chemin lorsqu'on affiche le r�sultat

## Input

Le programme accepte un fichier au format .txt. Le labyrinthe sera d�crit comme un bloc rectangulaire uniquement. Les seuls caract�res autoris�s sont not�s pr�c�demment sans le P.

#### Exemple de labyrinthe
`WWWWW`

`EDEEE`

`WWWWE`

`EEEEE`

`AEEEW`

## M�thode � lancer

### Affichage dans la console

- Placer son labyrinthe dans le dossier data et le nommer "labyrinthe.txt" (il y en a d�j� un par d�faut)
- Lancer la m�thode src/MainTest.java

Le programme affichera, si elle existe, la solution dans la console en affichant le chemin par des "P" .

La solution sera �crite dans le fichier `export.txt`dans le dossier data.

#### Exemple de r�solution du labyrinthe donnée en exemple

`WWWWW`

`EDPPP`

`WWWWP`

`EPPPP`

`APEEW`

### Avec interface graphique
#### Importer et modifier son labyrinthe : 
- Placer son labyrinthe dans le dossier data et le nommer "labyrinthe.txt" (il y en a d�j� un par d�faut)
- Lancer la m�thode src/MainTestUI.java
- On peut modifier le labyrinthe ou en ouvrir un autre par la suite

#### Modifier le labyrinthe
- Lancer la m�thode src/MainTestUI.java
- Appuyer sur le bouton File>Edit 
- Choisir la taille
- Modifier les cases en cliquant sur les boutons de types puis sur la case
- Une fois le labyrinthe termin� on peut le save ou save AS
- Pour r�soudre le labyrinthe, cliquer sur Solve dans le menu Maze, et unsolve pour revenir en arri�re
- On peut revenir au dernier labyrinthe saved en appuyant sur Maze>Reset

#### Ouvrir un nouveau laby
- Ouvrir un nouveau laby avec File>Open 

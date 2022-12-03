# Explication de l'exécution du labyrinthe  :

## Types de case

- W : case de mur
- E : case vide
- D : case de départ. Il ne peut en avoir qu'une
- A : case d'arrivée. Il ne peut en avoir qu'une
- P : case de chemin lorsqu'on affiche le résultat

## Input

Le programme accepte un fichier au format .txt. Le labyrinthe sera décrit comme un bloc rectangulaire uniquement. Les seuls caractères autorisés sont notés précédemment sans le P.

#### Exemple de labyrinthe
`WWWWW`

`EDEEE`

`WWWWE`

`EEEEE`

`AEEEW`

## Méthode à  lancer

### Affichage dans la console

- Placer son labyrinthe dans le dossier data et le nommer "labyrinthe.txt" (il y en a déjà un par défaut)
- Lancer la méthode src/MainTest.java

Le programme affichera, si elle existe, la solution dans la console en affichant le chemin par des "P" .

La solution sera écrite dans le fichier `export.txt`dans le dossier data.

#### Exemple de résolution du labyrinthe donnÃ©e en exemple

`WWWWW`

`EDPPP`

`WWWWP`

`EPPPP`

`APEEW`

### Avec interface graphique
#### Importer et modifier son labyrinthe : 
- Placer son labyrinthe dans le dossier data et le nommer "labyrinthe.txt" (il y en a déjà un par défaut)
- Lancer la méthode src/MainTestUI.java
- On peut modifier le labyrinthe ou en ouvrir un autre par la suite

#### Modifier le labyrinthe
- Lancer la méthode src/MainTestUI.java
- Appuyer sur le bouton File>Edit 
- Choisir la taille
- Modifier les cases en cliquant sur les boutons de types puis sur la case
- Une fois le labyrinthe terminé on peut le save ou save AS
- Pour résoudre le labyrinthe, cliquer sur Solve dans le menu Maze, et unsolve pour revenir en arrière
- On peut revenir au dernier labyrinthe saved en appuyant sur Maze>Reset

#### Ouvrir un nouveau laby
- Ouvrir un nouveau laby avec File>Open 

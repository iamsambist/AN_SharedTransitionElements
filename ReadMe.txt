Before Implementing Transition Animation Build An Complete transition process with out animation than implement the transtion animation.

To Share Transition Common Views We need 2 things?
1. SharedTransitionScope - We gets it Through the SharedTransitionLayout 
	that means Shared Transition layout must be the parent layout of both of screen where we gonna share animation for common views?
it is Responsiable for Finding Matching Elements, Doing lookahead calculation between 2 states 
2. AnimatedVisibilityScope - 
	Used to drive or see the progress between the shared elements transition and decide what should be displayed on screen at any point between transition.
	AnimatedVisibilityScope can be provided by few Different Layouts such as
	1. AnimatedContent()
	2. AnimatedVisibility()
	3. NavHost()

3. Pass both Scope to Home or Detail screen as these are used to gain access to shareElement() Modifier
	For Long Application we should use Composition Local to store these scopes and avoid pass very far down the composition hierarchy.

Problem I faced ?
1. Key mismatching 
	Since i am using dynamic list which contains 9 View Composable 3 TextView for title. 3 text view for Description and 3 ImageView
	Firstly i only used 3 key to differenciate them for title itemName , itemDes and itemLogo ... 
	Due to this 
	I do Have a same key for different elements which cause my views to be appeared in different Position.
	
Solution :
	For each List Item there should be a Unique Key _ so i add key with there index dynamically to make them unique.

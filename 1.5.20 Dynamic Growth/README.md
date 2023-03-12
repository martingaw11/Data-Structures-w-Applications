# Dynamic Union Find

After learning about the different variations of Union Find our assignment was to implement a Union Find that is dynamic in its growth. Meaning that it does not take a fixed amount of sites for the network, instead it will constantly add new sites when necessary.

## Weighted Union Find

I specifically used the idea of Weighted Union Find for my Dynamic Union Find to make the program faster than the other union finds. Since Weighted Union Find is the back bone of my Dynamic Union Find, I used the basic implementation of Weighted Union UF from algs4 and changed the data types and added a new newSite() method.

## Testing

Within .bin/results/ is the results of my testing. Since Weight Union UF was the premise behind my Dynamic UF, I decided to use their implementation from algs4 to produce concrete data that can be used to compare my results from using Dynamic UF.

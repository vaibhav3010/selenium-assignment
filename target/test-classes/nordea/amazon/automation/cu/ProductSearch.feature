Feature: 1. It should be possible to search for Nikon Items at http://www.amazon.com 
         2. Sort by price, High to low and then open second item from search results.
		 3. Find the KeyWord Nikon D3X from the Product title of the second item 

Scenario: Find Nikon D3X from Nikon Product List

    Given Amazon home page is open and Maximized
    When User searches for Nikon
    And Sorts results by price : high to low
    And Opens the second item on the List
    Then Product title of Second item contains Nikon D3X
        
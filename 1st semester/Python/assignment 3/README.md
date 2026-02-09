# Geospatial Data & Nested Structures

A Python module designed to handle geographical abstract data types and navigate complex, deeply nested data structures.

## Geospatial Features
* **Location ADT:** Defines an Abstract Data Type for a `Location` (Name, Latitude, Longitude, Type).
* **Haversine Implementation:** Calculates the precise distance (in km) between two coordinates on Earth, accounting for the planet's curvature.
* **Nearest Neighbor Search:** Algorithms to filter and find the closest Point of Interest (POI) from a list of locations (e.g., finding the nearest "monument" or "square").

## Deep Data Traversal
* **`pick_cherries`:** A set of recursive algorithms designed to traverse and extract data from arbitrarily deep, nested lists (e.g., `['item', ['item', None]]`).
* **Nested Access:** Demonstrates how to access elements in multi-dimensional list structures.

## Usage Example
```python
# Create locations
aueb = location('AUEB', 37.994097, 23.732253, 'university')
monastiraki = location('Monastiraki', 37.976362, 23.725947, 'square')

# Calculate distance
dist = distance(aueb, monastiraki)
print(f"Distance: {dist:.2f} km")

# Print details
print_location(monastiraki)
# Object-Oriented Clock Simulation

A modular simulation of a digital clock system built using Python's Object-Oriented Programming (OOP) principles. This project demonstrates inheritance, composition, and polymorphism.

## Class Architecture

### Core Components
* **`Counter`:** Basic incrementing logic.
* **`CyclicCounter`:** Inherits from Counter; resets to zero after reaching a limit (modulo arithmetic).
* **`CascadeCounter`:** A "smart" counter that triggers a connected "next" counter when it wraps around (e.g., Seconds trigger Minutes).

### Clock Implementations
* **`Clock`:** Standard digital timekeeping (HH:MM:SS) built by composing three `CascadeCounter` objects.
* **`RomanClock`:** A polymorphic variant that displays time using **Roman Numerals** (e.g., `XXIII:LIX`).
* **`DayClock`:** Extends the standard clock to track days of the week, advancing the day when the time passes `23:59:59`.

## Technical Concepts
* **Inheritance:** Extending functionality from base classes (`Counter` -> `CyclicCounter`).
* **Composition:** Building complex objects (`Clock`) from smaller objects.
* **Polymorphism:** Overriding the `__str__` method to change how time is displayed across different clock types.
* **Method Overriding:** Customizing `advance()` logic in subclasses.

import React, { useState } from 'react'
import AddFoodForm from "./AddFoodForm"



const FoodMain = () => {
    const [food, setFood] = useState([]);

    const addFood = newFood => {
        setFood({ ...food, newFood })
    }

    return (
        <AddFoodForm food={food} addFood={addFood} />
    )
}
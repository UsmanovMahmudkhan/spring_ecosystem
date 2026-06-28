Task tracker Project:

1. User should add(`post`) task 
2. User should update(`put`) task
3. User should delete(`delete`) task
4. User should mark(`put`) task
5. User should list(`get`) all tasks
6. User should print(`get`) tasks that are not marked
7. User should print(`get`) tasks that are in progress
8. User should print(`get`) one by one by **id** and/or **status**, 

Entity:
1. ID `int` - number assigned to tasks
2. description `string` - about task
3. status `enum` - todo, progress, done
4. createdAt `long` -time created
5. updatedAt `long` - finished or updated


EndPoints:

1. localhost/**add/?desctiption=STRING&status=ENUM**
2. localhost/**update/{ID}/status=??**
3. localhost/**delete/{ID}/**
4. localhost/**update/{ID}/status=??**
5. localhost/**list/all_tasks**
6. localhost/**list/todo**
7. localhost/**list/progress**
8. localhost/**list/done**
8. localhost/**list/tasks/{id}** 
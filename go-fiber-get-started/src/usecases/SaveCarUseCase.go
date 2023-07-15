package usecases

import "github.com/lucasmancan/go-get-started/src/models"

type saveCarUseCase struct {
	Array []models.Car
}

func NewSaveUserUseCase() saveCarUseCase {

	cars := []models.Car{{1, "asd", models.Model{1, "asd"}}, {1, "asd", models.Model{1, "asd"}}, {1, "asd", models.Model{1, "asd"}}}

	return saveCarUseCase{cars}
}

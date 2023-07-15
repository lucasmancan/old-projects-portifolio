package main

import (
	"os"

	"github.com/gofiber/fiber/v2"
	"github.com/lucasmancan/go-get-started/src/usecases"
)

func main() {

	port := os.Getenv("PORT")
	if port == "" {
		port = "3000" // Default port if not specified
	}

	app := fiber.New()

	app.Use("/api", func(c *fiber.Ctx) error {
		return c.Next()
	})

	app.Get("/api", GetCars)

	app.Listen(":" + port)
}

func GetCars(c *fiber.Ctx) error {
	err := c.JSON(usecases.NewSaveUserUseCase().Array)
	return err
}

type Car struct {
	Id   int
	Name string
}

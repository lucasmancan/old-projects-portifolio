package models

type Car struct {
	Id    int    `json:"id"`
	Name  string `json:"name"`
	Model Model  `json:"model"`
}

type Model struct {
	Id   int    `json:"id"`
	Name string `json:"name"`
}

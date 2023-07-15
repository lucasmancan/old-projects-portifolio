export interface Sort {
  sorted: boolean;
  unsorted: boolean;
  empty: boolean;
}

// export class Pageable {
//   sort: Sort;
//   offset: number;
//   pageNumber: number;
//   pageSize: number;
//   unpaged: boolean;
//   paged: boolean;
// }

export class Pageable {
  content: any[];
  // pageable: Pageable;
  last: boolean;
  totalElements: number;
  totalPages: number;
  number: number = 0;
  size: number = 10;
  sort: Sort;
  numberOfElements: number;
  first: boolean;
  empty: boolean;
}

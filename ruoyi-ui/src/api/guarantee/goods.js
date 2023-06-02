import request from '@/utils/request'

// 查询物资信息列表
export function listGoods(query) {
  return request({
    url: '/guarantee/goods/list',
    method: 'get',
    params: query
  })
}

// 查询物资信息详细
export function getGoods(id) {
  return request({
    url: '/guarantee/goods/' + id,
    method: 'get'
  })
}

// 新增物资信息
export function addGoods(data) {
  return request({
    url: '/guarantee/goods',
    method: 'post',
    data: data
  })
}

// 修改物资信息
export function updateGoods(data) {
  return request({
    url: '/guarantee/goods',
    method: 'put',
    data: data
  })
}

// 删除物资信息
export function delGoods(id) {
  return request({
    url: '/guarantee/goods/' + id,
    method: 'delete'
  })
}

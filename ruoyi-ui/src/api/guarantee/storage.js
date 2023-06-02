import request from '@/utils/request'

// 查询仓库信息列表
export function listStorage(query) {
  return request({
    url: '/guarantee/storage/list',
    method: 'get',
    params: query
  })
}

// 查询仓库信息详细
export function getStorage(id) {
  return request({
    url: '/guarantee/storage/' + id,
    method: 'get'
  })
}

// 新增仓库信息
export function addStorage(data) {
  return request({
    url: '/guarantee/storage',
    method: 'post',
    data: data
  })
}

// 修改仓库信息
export function updateStorage(data) {
  return request({
    url: '/guarantee/storage',
    method: 'put',
    data: data
  })
}

// 删除仓库信息
export function delStorage(id) {
  return request({
    url: '/guarantee/storage/' + id,
    method: 'delete'
  })
}

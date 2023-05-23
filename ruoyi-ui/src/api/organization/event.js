import request from '@/utils/request'

// 查询应急事件列表
export function listEvent(query) {
  return request({
    url: '/organization/event/list',
    method: 'get',
    params: query
  })
}

// 查询应急事件详细
export function getEvent(id) {
  return request({
    url: '/organization/event/' + id,
    method: 'get'
  })
}

// 新增应急事件
export function addEvent(data) {
  return request({
    url: '/organization/event',
    method: 'post',
    data: data
  })
}

// 修改应急事件
export function updateEvent(data) {
  return request({
    url: '/organization/event',
    method: 'put',
    data: data
  })
}

// 删除应急事件
export function delEvent(id) {
  return request({
    url: '/organization/event/' + id,
    method: 'delete'
  })
}
